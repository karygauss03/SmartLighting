package tn.cot.smartlighting.ressources;

import tn.cot.smartlighting.Exceptions.EmployeeAlreadyExistsException;
import tn.cot.smartlighting.Exceptions.EmployeeNotFoundException;

import tn.cot.smartlighting.entities.Employee;

import tn.cot.smartlighting.filters.Secured;

import tn.cot.smartlighting.entities.PasswordUpdate;
import tn.cot.smartlighting.repositories.EmployeeRepository;
import tn.cot.smartlighting.utils.Argon2Utils;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRessource {
    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    EmployeeRepository employeeRepository;
    @Inject
    Argon2Utils argon2Utils;
    @GET
    @Secured
    @RolesAllowed("ADMIN")
    public List<Employee> findActiveEmployees() {
        return employeeRepository.findByArchived(false).collect(Collectors.toList());
    }
    @POST
    @Path("/signup")
    public Response createEmployee(@Valid Employee employee) {
        try {
            if (employeeRepository.findById(employee.getEmail()).isPresent()) {
                throw new EmployeeAlreadyExistsException("Employee with id " + employee.getEmail() + " already exists");
            }
            employee.hashPassword(employee.getPassword(), argon2Utils);
            employee.setCreated_on(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a")));
            employeeRepository.save(employee);
            return Response.ok("Employee added successfully!").build();
        }
        catch (EmployeeAlreadyExistsException e) {
            return  Response.status(400, e.getMessage()).build();
        }
    }
    @POST
    @Secured
    @RolesAllowed("ADMIN")
    @Path("/add-employee")
    public Response addEmployee(@Valid Employee employee) {
        try {
            if (employeeRepository.findById(employee.getEmail()).isPresent()) {
                throw new EmployeeNotFoundException("Employee with id " + employee.getEmail() + " already exist!");
            }
            employee.hashPassword(employee.getPassword(), argon2Utils);
            employee.setCreated_on(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a")));
            employeeRepository.save(employee);
            return Response.ok("Employee added successfully!").build();
        }
        catch (EmployeeNotFoundException e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
     //We need to add update password (oldPass, newPass)
    @GET
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    @Path("/{email}")
    public Employee getEmployeeById(@PathParam("email") String email) {
        return employeeRepository.findById(email).orElseThrow(NOT_FOUND);
    }
    @PUT
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    @Path("/{email}")
    public Response updateEmployeeById(@PathParam("email") String email, Employee employee) {
        try {
            if (!employeeRepository.findById(email).isPresent()){
                throw new EmployeeNotFoundException("Employee with email " + email + " NOT FOUND!");
            }
            Employee employeeInDb = employeeRepository.findById(email).get();
            if (employeeInDb.getForename() != employee.getForename()) {
                employeeInDb.setForename(employee.getForename());
            }
            if (employeeInDb.getSurname() != employee.getSurname()) {
                employeeInDb.setSurname(employee.getSurname());
            }
            if (employeeInDb.getRoles() != employee.getRoles()) {
                employeeInDb.setRoles(employee.getRoles());
            }
            if (employeeInDb.getAddress_id() != employee.getAddress_id()) {
                employeeInDb.setRoles(employee.getRoles());
            }
            if (employeeInDb.getPhoneNumber() != employee.getPhoneNumber()) {
                employeeInDb.setPhoneNumber(employee.getPhoneNumber());
            }
            employeeRepository.save(employeeInDb);
            return Response.ok("Employee with id " + email + " updated successfully!").build();
        }
        catch (EmployeeNotFoundException e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
    @PATCH
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    @Path("/update-password/{email}")
    public Response updatePassword(@PathParam("email") String email, PasswordUpdate passwordUpdate) {
        try {
            if (!employeeRepository.findById(email).isPresent()) {
                throw new EmployeeNotFoundException("Employee with email " + email + " NOT FOUND!");
            }
            Employee employeeInDb = employeeRepository.findById(email).get();
            if (!argon2Utils.check(employeeInDb.getPassword(), passwordUpdate.getOldPassword().toCharArray())) {
                return Response.status(400, "Passwords Doesn't match").build();
            }
            employeeInDb.setPassword(passwordUpdate.getNewPassword());
            employeeInDb.hashPassword(employeeInDb.getPassword(), argon2Utils);
            employeeRepository.save(employeeInDb);
            return Response.ok("Password updated successfully").build();
        }
        catch (EmployeeNotFoundException e) {
            return Response.status(400, "Employee with email " + email + " NOT FOUND!").build();
        }
    }
    @DELETE
    @Secured
    @RolesAllowed("ADMIN")
    @Path("/{email}")
    public Response deleteEmployee(@PathParam("email") String email) {
        try {
            if (!employeeRepository.findById(email).isPresent()) {
                throw new EmployeeNotFoundException("Employee with email " + email + " NOT FOUND!");
            }
            Employee employeeInDb = employeeRepository.findById(email).get();
            employeeInDb.setArchived(true);
            employeeRepository.save(employeeInDb);
            return Response.ok("Employee with email " + email + " archived!").build();
        }
        catch (EmployeeNotFoundException e){
            return Response.status(400, e.getMessage()).build();
        }
    }
}
