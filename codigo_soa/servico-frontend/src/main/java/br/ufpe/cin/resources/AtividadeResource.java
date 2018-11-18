package br.ufpe.cin.resources;

import br.ufpe.cin.models.AtividadeHTML;
import br.ufpe.cin.models.HomeHTML;
import br.ufpe.cin.projectmodels.Professor;
import br.ufpe.cin.projectmodels.Usuario;
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

@Path("/atividades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class AtividadeResource {
    @GET
    public Response pageProfessores() throws IOException {
        String url = "http://servicefachada:8080/cadastrar/atividade";
        String json = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();

        System.out.println("Resultado do json = " + json);
        AtividadeHTML atividadeHTML = new AtividadeHTML();
        String atividade = "";
        if (json.equals("true")) {
            String url2 = "http://servicefachada:8080/listar/atividade";
            String json2 = Jsoup.connect(url2)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute()
                    .body();

            System.out.println("Resultado do json2 = " + json2);

            ObjectMapper mapper = new ObjectMapper();
            Professor atividadeObj = mapper.readValue(json2, Professor.class);
            atividade = "<ul>\n" +
                    "<li>" + atividadeObj.getData() + "</li>\n" +
                    "<li>" + atividadeObj.getDescricao() + "</li>\n" +
                    "<br>\n" +
                    "<li>Participante</li>\n" +
                    "<ul>\n" +
                    "<li>" + atividadeObj.getParticipante().getNome() + "</li>\n" +
                    "<li>" + atividadeObj.getParticipante().getEmail() + "</li>\n" +
                    "<li>" + atividadeObj.getParticipante().getRfid() + "</li>\n" +
                    "</ul>\n" +
                    "</ul>\n";
        }
        return Response.ok(atividadeHTML.formatString(atividade)).build();
    }
}
