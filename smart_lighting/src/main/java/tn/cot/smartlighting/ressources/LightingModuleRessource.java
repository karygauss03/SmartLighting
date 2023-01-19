package tn.cot.smartlighting.ressources;

import tn.cot.smartlighting.Exceptions.AddressNotFoundException;
import tn.cot.smartlighting.Exceptions.LightingModuleNotFoundException;
import tn.cot.smartlighting.entities.Address;
import tn.cot.smartlighting.entities.LightingModule;
import tn.cot.smartlighting.repositories.LightingModuleRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("lighting-modules")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LightingModuleRessource {
    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);

    @Inject
    LightingModuleRepository repository;

    @GET
    public List<LightingModule> findAll() {
        return repository.findByArchived(false).collect(Collectors.toList());
    }
    @GET
    @Path("/archived")
    public List<LightingModule> findArchivedAll() {
        return repository.findByArchived(true).collect(Collectors.toList());
    }
    @GET
    @Path("/active")
    public List<LightingModule> findActiveAll() {
        return repository.findByOn(true).collect(Collectors.toList());
    }
    @GET
    @Path("/broken")
    public List<LightingModule> findBrokenAll() {
        return repository.findByBroken(true).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        try {
            if (!repository.findById(id).isPresent()) {
                throw new LightingModuleNotFoundException("Lighting Module with id " + id + " NOT FOUND!");
            }
            return Response.ok(repository.findById(id).get()).build();
        }
        catch (LightingModuleNotFoundException e) {
            return Response.status(400, "Lighting Module with id " + id + " NOT FOUND!").build();
        }
    }
    @POST
    public void save(LightingModule lightingModule) {
        repository.save(lightingModule);
    }
    @PUT
    @Path("/{id}")
    public Response updateById(@PathParam("id") String id, LightingModule newLightingModule) {
        try {
            if (!repository.findById(id).isPresent()) {
                throw new LightingModuleNotFoundException("Lighting Module with id " + id + " NOT FOUND!");
            }
            LightingModule lightingModule = repository.findById(id).get();
            if (lightingModule.getLatitude() != newLightingModule.getLatitude()) {
                lightingModule.setLatitude(newLightingModule.getLatitude());
            }
            if (lightingModule.getLongitude() != newLightingModule.getLongitude()) {
                lightingModule.setLongitude(newLightingModule.getLongitude());
            }
            if (lightingModule.getAddressId() != newLightingModule.getAddressId()) {
                lightingModule.setAddressId(newLightingModule.getAddressId());
            }
            repository.save(lightingModule);
            return Response.ok("Lighting Module with id " + id + " Updated successfully").build();
        }
        catch (LightingModuleNotFoundException e) {
            return Response.status(400, "Lighting Module with id " + id + " NOT FOUND!").build();
        }
    }
    @PATCH
    @Path("/toggle/{id}")
    public Response changeStatus(@PathParam("id") String id) {
        try {
            if (!repository.findById(id).isPresent()) {
                throw new LightingModuleNotFoundException("LightingModule with id " + id + " NOT FOUND!");
            }
            LightingModule lightingModule = repository.findById(id).get();
            lightingModule.setOn(!lightingModule.isOn());
            lightingModule.setBroken(!lightingModule.isBroken());
            repository.save(lightingModule);
            return Response.ok("LightingModule status with id " + id + " updated successfully!").build();
        }
        catch(LightingModuleNotFoundException e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String id) {
        try {
            if (!repository.findById(id).isPresent()) {
                throw new LightingModuleNotFoundException("LightingModule with id " + id + " NOT FOUND!");
            }
            LightingModule lightingModule = repository.findById(id).get();
            lightingModule.setArchived(true);
            repository.save(lightingModule);
            return Response.ok("LightingModule archived").build();
        }
        catch (LightingModuleNotFoundException e) {
            return Response.status(400, "Address NOT FOUND").build();
        }
    }
}
