package br.ufpe.cin.projectmodels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class ProfessorForm {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String email;

    @JsonCreator
    public ProfessorForm(
            @JsonProperty("nome") String data,
            @JsonProperty("email") String email) {
        this.nome = nome;
        this.email = email;
    }


    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
}
