package tn.cot.smartlighting.ressources;

import tn.cot.smartlighting.Exceptions.AddressNotFoundException;
import tn.cot.smartlighting.entities.Address;
import tn.cot.smartlighting.repositories.AddressRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("addresses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressRessource {
    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    AddressRepository repository;

    @GET
    public List<Address> findCurrentAll() {
        return repository.findByArchived(false).collect(Collectors.toList());
    }
    @GET
    @Path("/archived")
    public List<Address> findArchivedAll() {
        return repository.findByArchived(true).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        try {
            if (!repository.findById(id).isPresent()){
                throw new AddressNotFoundException("Address with id " + id + " NOT FOUND!");
            }
            return Response.ok(repository.findById(id).get()).build();
        }
        catch (AddressNotFoundException e) {
            return Response.status(400, "Address with id " + id + " NOT FOUND!").build();
        }
    }
    @POST
    public Response save(Address add) {
        try {
            if (repository.findById(add.getId()).isPresent()) {
                throw new AddressNotFoundException("City with id " + add.getId() + " already exist!");
            }
            repository.save(add);
            return Response.ok("Address added successfully").build();
        }
        catch (AddressNotFoundException e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String id) {
        try {
            if (!repository.findById(id).isPresent()) {
                throw new AddressNotFoundException("Address with id " + id + " NOT FOUND!");
            }
            Address address = repository.findById(id).get();
            address.setArchived(true);
            repository.save(address);
            return Response.ok("Address archived").build();
        }
        catch (AddressNotFoundException e) {
            return Response.status(400, "Address NOT FOUND").build();
        }
    }
    @PUT
    @Path("/{id}")
    public Response updateById(@PathParam("id") String id, Address newAddress) {
        try {
            if (!repository.findById(id).isPresent()){
                throw new AddressNotFoundException("Address with id " + id + " NOT FOUND!");
            }
            Address address = repository.findById(id).get();
            if (address.getCityId() != newAddress.getCityId()) {
                address.setCityId(newAddress.getCityId());
            }
            if (address.getCountry() != newAddress.getCountry()) {
                address.setCountry(newAddress.getCountry());
            }
            if (address.getDescription() != newAddress.getDescription()) {
                address.setDescription(newAddress.getDescription());
            }
            if (address.getZipCode() != newAddress.getZipCode()) {
                address.setZipCode(newAddress.getZipCode());
            }
            repository.save(address);
            return Response.ok("Address with id " + id + " Updated successfully").build();
        }
        catch (AddressNotFoundException e) {
            return Response.status(400, "Address with id " + id + " NOT FOUND!").build();
        }
    }
}
