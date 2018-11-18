package br.ufpe.cin.db;

import br.ufpe.cin.models.Usuario;

import java.util.ArrayList;

public class UsuariosDB {
    private ArrayList<Usuario> usuarios;

    public UsuariosDB() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Paulo", "pglj2@cin.ufpe.br", "as6df87sf68sdf7"));
        usuarios.add(new Usuario("Rodrigo", "rcac@cin.ufpe.br", "fgh564gh86375df"));
        usuarios.add(new Usuario("Thiago", "tmb2@cin.ufpe.br", "jh867ghj7h5h789"));
    }

    public Usuario getUsuarioPorNome(String nome) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario temp = usuarios.get(i);
            if (temp.getNome().equalsIgnoreCase(nome)) {
                return temp;
            }
        }
        return null;
    }
}
