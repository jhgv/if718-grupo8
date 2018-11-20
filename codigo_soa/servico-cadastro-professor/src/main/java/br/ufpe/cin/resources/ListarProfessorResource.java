package br.ufpe.cin.resources;

import br.ufpe.cin.db.ProfessorDB;
import br.ufpe.cin.models.Professor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/listar/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ListarProfessorResource {
    private ProfessorDB professorDB;

    public ListarProfessorResource(ProfessorDB professorDB) {
        this.professorDB = professorDB;
    }

    @GET
    public Response listarProfessores() {
        ArrayList<Professor> professor = professorDB.listarProfessores();
        return Response.ok(professor).build();
    }
}
