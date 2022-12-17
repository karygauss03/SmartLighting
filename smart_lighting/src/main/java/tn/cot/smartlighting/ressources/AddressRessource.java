package tn.cot.smartlighting.ressources;

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
    public List<Address> findAll() {
        return repository.findAll().collect(Collectors.toList());
    }

    @POST
    public void save(Address add) {
        repository.save(add);
    }
}
