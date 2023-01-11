package tn.cot.smartlighting.ressources;

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
        return repository.findAll().collect(Collectors.toList());
    }
    @POST
    public void save(LightingModule lightingModule) {
        repository.save(lightingModule);
    }
}
