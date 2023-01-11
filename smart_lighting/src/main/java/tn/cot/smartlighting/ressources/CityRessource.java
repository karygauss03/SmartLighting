package tn.cot.smartlighting.ressources;

import tn.cot.smartlighting.entities.City;
import tn.cot.smartlighting.entities.Country;
import tn.cot.smartlighting.repositories.CityRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
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
    public List<City> findAll() {
        return repository.findAll().collect(Collectors.toList());
    }
    @GET
    @Path("/country/{country}")
    public List<City> findByCountry(@PathParam("country") Country country) {
        return repository.findByCountry(country).collect(Collectors.toList());
    }
    @POST
    public void save(City city) {
        repository.save(city);
    }
}
