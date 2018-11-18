package br.ufpe.cin.resources;

import br.ufpe.cin.models.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/listar/atividade")
@Produces(MediaType.APPLICATION_JSON)
public class ListarAtividadeResource {
    @GET
    public Response listarAtividade() throws IOException {
        String url = "http://servicocadastroprofessor:8080/listar/atividade";
        String json = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();
        return Response.ok(json).build();
    }
}
