package com.example.Professor.Professor;


import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class ProfessorRepository {

    public void save(ProfessorDAO professor) {
    }

    public ProfessorDAO get(String id) {
        return new ProfessorDAO("id", "name", 12, LocalDate.now());
    }
}
