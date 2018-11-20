package br.ufpe.cin.resources;

import br.ufpe.cin.db.ProfessorDB;
import br.ufpe.cin.models.Professor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cadastrar/professor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CadastrarProfessorResource {
    private ProfessorDB professorDB;

    public CadastrarProfessorResource(ProfessorDB professorDB) {
        this.professorDB = professorDB;
    }

    @POST
    public Response cadastrarProfessor(Professor professor) {
        System.out.println("CADASTRO");
        professorDB.addProfessor(professor);
        return Response.ok().status(201).build();
    }

    // TODO: Usar para validação
    @GET
    public Response isThereProfessor() {
        boolean retorno = professorDB.existeProfessor();
        return Response.ok(retorno).build();
    }
}
