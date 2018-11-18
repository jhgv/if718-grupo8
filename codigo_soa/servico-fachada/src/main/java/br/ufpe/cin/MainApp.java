package br.ufpe.cin;

import br.ufpe.cin.resources.BuscarPorNomeResource;
import br.ufpe.cin.resources.CadastrarProfessorResource;
import br.ufpe.cin.resources.ListarAtividadeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceFachadaConfiguration> {
    public static void main(final String[] args) throws Exception {
        new MainApp().run(args);
    }

    @Override
    public void run(ServiceFachadaConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new BuscarPorNomeResource());
        environment.jersey().register(new CadastrarProfessorResource());
        environment.jersey().register(new ListarAtividadeResource());
    }
}
