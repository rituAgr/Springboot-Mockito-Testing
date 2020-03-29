package com.example.Professor.Professor;


import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ProfessorRepository {

    public void save(ProfessorDAO professor) {
    }

    public ProfessorDAO get(String id) {
        return new ProfessorDAO(id, "name", 12, new Date());
    }
}
