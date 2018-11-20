package br.ufpe.cin.db;

import br.ufpe.cin.models.Professor;

import java.util.ArrayList;

public class ProfessorDB {
    private ArrayList<Professor> professors;

    public ProfessorDB() {
        professors = new ArrayList<>();
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public ArrayList<Professor> listarProfessores() {
        if (!existeProfessor()) {
            return new ArrayList<>();
        }
        return professors;
    }

    public boolean existeProfessor() {
        if (professors.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
