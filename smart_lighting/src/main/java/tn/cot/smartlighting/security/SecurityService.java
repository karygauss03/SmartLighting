package tn.cot.smartlighting.security;

import tn.cot.smartlighting.Exceptions.*;
import tn.cot.smartlighting.entities.Employee;
import tn.cot.smartlighting.entities.Role;
import tn.cot.smartlighting.repositories.EmployeeRepository;
import tn.cot.smartlighting.utils.Argon2Utils;

import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SecurityService {

    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private Argon2Utils argon2Utils;
    @Inject
    private SecurityContext securityContext;

    public void create(Employee employee) {
        if (employeeRepository.findById(employee.getEmail()).isPresent()) {
            throw new EmployeeNotFoundException("Employee with email  " + employee.getEmail());
        } else {
            employee.hashPassword(employee.getPassword(), argon2Utils);
            employeeRepository.save(employee);
        }
    }

    public void delete(String email) {
        employeeRepository.deleteById(email);
    }

    public void updatePassword(String email, Employee dto) {
        final Principal principal = securityContext.getUserPrincipal();
        if (isForbidden(email, securityContext, principal)) {
            throw new EmployeeForbiddenException("Forbidden");
        }
        final Employee employee = employeeRepository.findById(email)
                .orElseThrow(() -> new EmployeeNotFoundException(email));
        employee.hashPassword(dto.getPassword(), argon2Utils);
        employeeRepository.save(employee);

    }

    public Employee getUser() {
        final Principal principal = securityContext.getUserPrincipal();
        if (principal == null) {
            throw new EmployeeNotAuthorizedToCreateAccountException("Employee NOT AUTHORIZED!");
        }
        final Employee employee = employeeRepository.findById(principal.getName())
                .orElseThrow(() -> new EmployeeNotFoundException(principal.getName()));
        return employee;
    }

    public void addRole(String email, Role role) {
        final Employee employee = employeeRepository.findById(email)
                .orElseThrow(() -> new EmployeeNotFoundException(email));

        Set<Role> roles = employee.getRoles() ;
        roles.add(role) ;
        employee.setRoles(roles);
        employeeRepository.save(employee);
    }

    public void removeRole(String  email , Role role) {
        final Employee user = employeeRepository.findById(email)

                .orElseThrow(() -> new EmployeeAlreadyExistsException(email));

        Set<Role> roles=user.getRoles() ;
        roles.remove(role) ;
        user.setRoles(roles);
        employeeRepository.save(user);
    }

    public List<Employee> getUsers() {
        return employeeRepository.findAll().collect(Collectors.toList());
    }

    private boolean isForbidden(String  email, SecurityContext context, Principal principal) {
        return !(context.isUserInRole(Role.ADMIN.name()));

    }

    public Employee findBy(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new EmployeeNotAuthorizedException("Unauthorized"));
    }

    public Employee findBy(String email, String password) {
        System.out.println("------------------------------------------------");
        System.out.println(employeeRepository.findById(email).toString());
        final Employee user = employeeRepository.findById(email)
                .orElseThrow(() -> new EmployeeNotAuthorizedException("Unauthorized"));
        System.out.println(argon2Utils.check(user.getPassword() ,password.toCharArray()));
        if (argon2Utils.check(user.getPassword() ,password.toCharArray() )) {

            return user;
        }
        throw new EmployeeNotAuthorizedException("Unauthorized");

    }


}
