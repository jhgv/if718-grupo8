package br.ufpe.cin.resources;

import br.ufpe.cin.models.CadastrarAtividadeHTML;
import br.ufpe.cin.models.CadastrarAtividadeSucessoHTML;
import br.ufpe.cin.projectmodels.Professor;
import br.ufpe.cin.projectmodels.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/cadastroAtividade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class CadastrarProfessorResource {
    @GET
    public Response pageCadastrarAtividade() {
        CadastrarAtividadeHTML cadastrarAtividadeHTML = new CadastrarAtividadeHTML();
        return Response.ok(cadastrarAtividadeHTML.getHtml()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response pageCadastrarAtividadePost(@FormParam("usuario") String usuario,
                                               @FormParam("data") String data,
                                               @FormParam("description") String description) throws IOException {
        System.out.println("Usuario = " + usuario);
        System.out.println("Data = " + data);
        System.out.println("Descricao = " + description);
        String url = "http://servicefachada:8080/buscar/usuario?nome=" + usuario;
        String json = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();

        ObjectMapper mapper = new ObjectMapper();
        Usuario usuarioObj = mapper.readValue(json, Usuario.class);
        Professor atividade = new Professor(data, description, usuarioObj);
        String atividadeJson = mapper.writeValueAsString(atividade);
        System.out.println(atividadeJson);
        //.data("atividade", atividadeJson)
        int statusCode = Jsoup.connect("http://servicefachada:8080/cadastrar/atividade")
                .requestBody(atividadeJson)
                .header("Content-Type", "application/json")
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .execute()
                .statusCode();
        if (statusCode == 201) {
            CadastrarAtividadeSucessoHTML cadastrarAtividadeSucessoHTML = new CadastrarAtividadeSucessoHTML();
            return Response.ok(cadastrarAtividadeSucessoHTML.getHtml()).build();
        } else {
            return Response.serverError().build();
        }
    }
}
