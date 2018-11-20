package br.ufpe.cin.resources;

import br.ufpe.cin.models.ProfessorHTML;
import br.ufpe.cin.projectmodels.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Path("/professores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class ProfessorResource {
    @GET
    public Response pageProfessores() throws IOException {
        System.out.println("FRONTEND");
        String url = "http://servicefachada:8080/listar/professor";
        String json = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();

        System.out.println("Resultado do json = " + json);
        ProfessorHTML professorHTML = new ProfessorHTML();


        String professor = "";

        ObjectMapper mapper = new ObjectMapper();
        Professor[] professorObjs = mapper.readValue(json, Professor[].class);
        List<Professor> professoresList = Arrays.asList(professorObjs);

        for(Professor professorObj : professoresList) {
            professor = professor + "<tr>\n" +
                    "<td>" + professorObj.getNome() + "</td>\n" +
                    "<td>" + professorObj.getEmail() + "</td>\n" +
                    "<td><button type=\"button\" class=\"btn btn-primary btn-sm\">edit</button>\n" +
                    "<button type=\"button\" class=\"btn btn-danger btn-sm\">remover</button></td>\n" +
                    "</tr>\n";
        }

        return Response.ok(professorHTML.formatString(professor)).build();
    }

}
