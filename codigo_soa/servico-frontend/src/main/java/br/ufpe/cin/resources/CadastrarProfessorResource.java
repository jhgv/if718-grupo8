package br.ufpe.cin.resources;

import br.ufpe.cin.models.CadastrarProfessorHTML;
import br.ufpe.cin.models.CadastrarProfessorSucessoHTML;
import br.ufpe.cin.projectmodels.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/cadastroProfessor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class CadastrarProfessorResource {
    @GET
    public Response pageCadastrarProfessor() {
        CadastrarProfessorHTML cadastrarProfessorHTML = new CadastrarProfessorHTML();
        return Response.ok(cadastrarProfessorHTML.getHtml()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response pageCadastrarProfessorPost(@FormParam("nome") String nome,
                                               @FormParam("email") String email) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Professor professor = new Professor(nome, email);
        String professorJson = mapper.writeValueAsString(professor);
        System.out.println("FRONTEND");
        System.out.println(professorJson);
        //.data("professor", professorJson)
        int statusCode = Jsoup.connect("http://servicefachada:8080/cadastrar/professor")
                .requestBody(professorJson)
                .header("Content-Type", "application/json")
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .execute()
                .statusCode();
        if (statusCode == 201) {
            CadastrarProfessorSucessoHTML cadastrarProfessorSucessoHTML = new CadastrarProfessorSucessoHTML();
            return Response.ok(cadastrarProfessorSucessoHTML.getHtml()).build();
        } else {
            return Response.serverError().build();
        }
    }
}
