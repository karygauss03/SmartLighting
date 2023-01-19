package tn.cot.smartlighting.ressources;

import tn.cot.smartlighting.Exceptions.EmployeeAlreadyExistsException;
import tn.cot.smartlighting.Exceptions.EmployeeNotFoundException;
import tn.cot.smartlighting.entities.Employee;
import tn.cot.smartlighting.filters.Secured;
import tn.cot.smartlighting.repositories.EmployeeRepository;
import tn.cot.smartlighting.utils.Argon2Utils;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.function.Supplier;

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

    @POST
    @Path("/signup")
    public Response createEmployee(@Valid Employee employee) {
        try {
            if (employeeRepository.findById(employee.getEmail()).isPresent()) {
                throw new EmployeeAlreadyExistsException(employee.getEmail() + " already exists");
            }
            employee.hashPassword(employee.getPassword(), argon2Utils);
            return Response.ok(employeeRepository.save(employee)).build();
        }
        catch (EmployeeAlreadyExistsException e) {
            return  Response.status(400, e.getMessage()).build();
        }
    }
     //We need to add update password (oldPass, newPass)

    @GET
    @Path("/{email}")

    public Employee getEmployeeById(@PathParam("email") String email) {
        return employeeRepository.findById(email).orElseThrow(NOT_FOUND);
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
            employeeRepository.deleteById(email);
            return Response.ok().build();
        }
        catch (EmployeeNotFoundException e){
            return Response.status(400, e.getMessage()).build();
        }
    }
}
