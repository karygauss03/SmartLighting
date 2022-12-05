package tn.smart_lighting.boundries;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/echoes")
public class EchoEndPoint {
    @GET
    @Path("/{name}")
    public Response getClichedMessage(@PathParam("name") String name){
        return Response.ok().entity("{\"Message\":\"Hello " + name + "!\"}").build();
    }
}
