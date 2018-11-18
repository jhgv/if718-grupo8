package br.ufpe.cin.resources;

import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/buscar/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BuscarPorNomeResource {
    @GET
    public Response buscarPorNome(@QueryParam("nome") NonEmptyStringParam nome) throws IOException {
        String url = "http://servicocadastrousuario:8080/buscar/usuario?nome=" + nome.get().get();
        String json = Jsoup.connect(url)
                           .method(Connection.Method.GET)
                           .ignoreContentType(true)
                           .execute()
                           .body();
        //Document doc = Jsoup.connect(url).get();
        //return Response.ok(doc.body()).build();
        return Response.ok(json).build();
    }
}
