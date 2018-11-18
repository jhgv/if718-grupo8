package br.ufpe.cin.models;

        import com.fasterxml.jackson.annotation.JsonCreator;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String email;
    @NotEmpty
    private String rfid;

    @JsonCreator
    public Usuario(
            @JsonProperty("nome") String nome,
            @JsonProperty("email") String email,
            @JsonProperty("rfid") String rfid) {
        this.nome = nome;
        this.email = email;
        this.rfid = rfid;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("rfid")
    public String getRfid() {
        return rfid;
    }
}
