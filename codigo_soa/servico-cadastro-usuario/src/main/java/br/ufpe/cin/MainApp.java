package br.ufpe.cin;

import br.ufpe.cin.resources.BuscarPorNomeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceCadastroUsuarioConfiguration> {
    public static void main(final String[] args) throws Exception {
        new MainApp().run(args);
    }

    @Override
    public void run(ServiceCadastroUsuarioConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new BuscarPorNomeResource());
    }
}
