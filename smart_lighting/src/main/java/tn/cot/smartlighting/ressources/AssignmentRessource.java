package tn.cot.smartlighting.ressources;

import tn.cot.smartlighting.entities.Assignment;
import tn.cot.smartlighting.filters.Secured;
import tn.cot.smartlighting.repositories.AssignmentRepository;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/assignments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssignmentRessource {
    @Inject
    AssignmentRepository repository;

    @GET
    @Secured
    @RolesAllowed("ADMIN")
    public List<Assignment> findAll() {
        return repository.findByRepaired(false).collect(Collectors.toList());
    }
    @GET
    @Path("/repaired")
    @Secured
    @RolesAllowed("ADMIN")
    public List<Assignment> findHistoric() {
        return repository.findByRepaired(true).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    @Secured
    @RolesAllowed("ADMIN")
    public Response findById(@PathParam("id") String id) {
        if (!repository.findById(id).isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Assignment with id " +
                    id + " NOT FOUND!").build();
        }
        return Response.ok(repository.findById(id).get()).build();
    }
    @GET
    @Path("/employee/{id}")
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    public Response findByEmployeeId(@PathParam("id") String id) {
        if (!repository.findByEmployeeId(id).findAny().isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Assignment for employee " +
                    id + " NOT FOUND!").build();
        }
        List<Assignment> assignments = repository.findByEmployeeId(id).collect(Collectors.toList());
        List<Assignment> activeAssignments = assignments.stream().filter(a -> a.isRepaired() == false).collect(Collectors.toList());
        return Response.ok(activeAssignments).build();
    }
    @GET
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    @Path("/employee/repaired/{id}")
    public Response findHistoricByEmployeeId(@PathParam("id") String id) {
        if (!repository.findByEmployeeId(id).findAny().isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Assignment for employee " +
                    id + " NOT FOUND!").build();
        }
        List<Assignment> assignments = repository.findByEmployeeId(id).collect(Collectors.toList());
        List<Assignment> inactiveAssignments = assignments.stream().filter(a -> a.isRepaired() == true).collect(Collectors.toList());
        return Response.ok(inactiveAssignments).build();
    }
    @POST
    @Secured
    @RolesAllowed("ADMIN")
    public Response addAssignment(Assignment assignment) {
        if (repository.findById(assignment.getAssignmentId()).isPresent()) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Assignment with id " +
                    assignment.getAssignmentId() + " already exists").build();
        }
        repository.save(assignment);
        return Response.ok("Assignment added successfully").build();
    }
    @PATCH
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    @Path("/{assignmentId}")
    public Response repaireLightingModule(@PathParam("assignmentId") String assignmentId) {
        if (!repository.findById(assignmentId).isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Assignment with id " +
                    assignmentId + " NOT FOUND!").build();
        }
        Assignment assignmentInDb = repository.findById(assignmentId).get();
        assignmentInDb.setRepaired(true);
        assignmentInDb.setRepairedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a")));
        repository.save(assignmentInDb);
        return Response.ok(assignmentInDb).build();
    }
    @PUT
    @Secured
    @RolesAllowed("ADMIN")
    @Path("/{assignmentId}")
    public Response updateAssignment(@PathParam("assignmentId") String id, Assignment assignment) {
        if (!repository.findById(id).isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Assignment with id " +
                    id + " NOT FOUND!").build();
        }
        Assignment assignmentInDb = repository.findById(id).get();
        if (assignmentInDb.getEmployeeId() != assignment.getEmployeeId()) {
            assignmentInDb.setEmployeeId(assignment.getEmployeeId());
        }
        if (assignmentInDb.getLightingModuleId() != assignment.getLightingModuleId()) {
            assignmentInDb.setLightingModuleId(assignment.getLightingModuleId());
        }
        repository.save(assignmentInDb);
        return Response.ok("Assignment with id " + id + " updated successfully!").build();
    }
    @DELETE
    @Secured
    @RolesAllowed("ADMIN")
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String id) {
        if (!repository.findById(id).isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Assignment with id " +
                    id + " NOT FOUND!").build();
        }
        repository.deleteById(id);
        return Response.ok("Assignment with id " + id + " deleted successfully").build();
    }
}
