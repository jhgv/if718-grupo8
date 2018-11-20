package br.ufpe.cin.resources;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/listar/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ListarProfessorResource {
    @GET
    public Response listarProfessor() throws IOException {
        System.out.println("CONTROLADOR");
        String url = "http://servicocadastroprofessor:8080/listar/professor";
        String json = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();
        return Response.ok(json).build();
    }
}
