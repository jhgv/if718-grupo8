package br.ufpe.cin.resources;

import br.ufpe.cin.models.HomeHTML;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/home")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class HomeResource {
    @GET
    public Response pageHome() {
        HomeHTML homeHTML = new HomeHTML();
        return Response.ok(homeHTML.getHtml()).build();
    }
}
