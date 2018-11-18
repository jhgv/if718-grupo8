package br.ufpe.cin.projectmodels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class AtividadeForm {
    @NotEmpty
    private String usuario;
    @NotEmpty
    private String data;
    @NotEmpty
    private String description;

    @JsonCreator
    public AtividadeForm(
            @JsonProperty("usuario") String usuario,
            @JsonProperty("data") String data,
            @JsonProperty("description") String description) {
        this.usuario = usuario;
        this.data = data;
        this.description = description;
    }

    @JsonProperty("usuario")
    public String getUsuario() {
        return usuario;
    }

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
}
