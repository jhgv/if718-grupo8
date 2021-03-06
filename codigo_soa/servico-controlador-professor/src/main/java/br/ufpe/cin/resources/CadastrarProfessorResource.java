package br.ufpe.cin.resources;

import br.ufpe.cin.models.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/cadastrar/professor")
@Produces(MediaType.APPLICATION_JSON)
public class CadastrarProfessorResource {
    @POST
    public Response cadastrarProfessor(Professor professor) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String professorJson = mapper.writeValueAsString(professor);
        System.out.println("Controlador");
        System.out.println(professorJson);
        int statusCode = Jsoup.connect("http://servicocadastroprofessor:8080/cadastrar/professor")
                .requestBody(professorJson)
                .header("Content-Type", "application/json")
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .execute()
                .statusCode();
        if (statusCode == 201) {
            return Response.ok().status(201).build();
        } else {
            return Response.serverError().build();
        }
    }
}
