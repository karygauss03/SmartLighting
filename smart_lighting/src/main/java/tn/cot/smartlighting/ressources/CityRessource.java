package tn.cot.smartlighting.ressources;

import sun.security.util.Length;
import tn.cot.smartlighting.Exceptions.CityNotFoundException;
import tn.cot.smartlighting.entities.City;
import tn.cot.smartlighting.entities.Country;
import tn.cot.smartlighting.filters.Secured;
import tn.cot.smartlighting.repositories.CityRepository;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("cities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CityRessource {
    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    private CityRepository repository;
    @GET
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    public List<City> findAll() {
        return repository.findAll().collect(Collectors.toList());
    }
    @GET
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        try {
            if (!repository.findById(id).isPresent()) {
                throw new CityNotFoundException("City with id " + id + " NOT FOUND!");
            }
            return Response.ok(repository.findById(id).get()).build();
        }
        catch (CityNotFoundException e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
    @GET
    @Secured
    @RolesAllowed({"ADMIN", "USER"})
    @Path("/country/{country}")
    public List<City> findByCountry(@PathParam("country") Country country) {
        return repository.findByCountry(country).collect(Collectors.toList());
    }
    @POST
    @Secured
    @RolesAllowed("ADMIN")
    public void save(City city) {
        repository.save(city);
    }
    @DELETE
    @Secured
    @RolesAllowed("ADMIN")
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try{
            if (!repository.findById(id).isPresent()){
                throw new CityNotFoundException("City with id " + id + " NOT FOUND!");
            }
            repository.deleteById(id);
            return Response.ok().build();
        }
        catch (CityNotFoundException e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
}
