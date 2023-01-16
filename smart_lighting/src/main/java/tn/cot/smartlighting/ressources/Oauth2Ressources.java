package tn.cot.smartlighting.ressources;

import tn.cot.smartlighting.security.Oauth2Request;
import tn.cot.smartlighting.security.Oauth2Response;
import tn.cot.smartlighting.security.Oauth2Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("oauth2")
public class Oauth2Ressources {
    @Inject
    private Oauth2Service service;

    @POST
    @Path("token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Oauth2Response token(Oauth2Request request) {
        switch (request.getGrandType()) {
            case PASSWORD:
                return service.token(request);
            case REFRESH_TOKEN:
                return service.refreshToken(request);
            default:
                throw new UnsupportedOperationException("No other types are supported");
        }

    }
}
