package br.ufpe.cin;

import br.ufpe.cin.db.ProfessorDB;
import br.ufpe.cin.resources.CadastrarProfessorResource;
import br.ufpe.cin.resources.ListarProfessorResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceCadastroProfessorConfiguration> {
    public static void main(final String[] args) throws Exception {
        new MainApp().run(args);
    }

    @Override
    public void run(ServiceCadastroProfessorConfiguration configuration, Environment environment) throws Exception {
        ProfessorDB professorDB = new ProfessorDB();
        environment.jersey().register(new CadastrarProfessorResource(professorDB));
        environment.jersey().register(new ListarProfessorResource(professorDB));
    }
}
