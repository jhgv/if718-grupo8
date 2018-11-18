package br.ufpe.cin.resources;

import br.ufpe.cin.db.UsuariosDB;
import br.ufpe.cin.models.Usuario;
import io.dropwizard.jersey.params.NonEmptyStringParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/buscar/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class BuscarPorNomeResource {
    private UsuariosDB usuariosDB;

    public BuscarPorNomeResource() {
        usuariosDB = new UsuariosDB();
    }

    @GET
    public Response buscarPorNome(@QueryParam("nome") NonEmptyStringParam nome) {
        Usuario usuario = usuariosDB.getUsuarioPorNome(nome.get().get());
        if (usuario == null) {
            return Response.ok("User not found").status(404).build();
        }
        return Response.ok(usuario).build();
    }
}
