package com.example.Professor.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

//    public

    public void add(ProfessorRequest professorRequest) {
        ProfessorDAO professor = new ProfessorDAO(
                professorRequest.id,
                professorRequest.name,
                professorRequest.NumberClassesPerCourse,
                new Date()
//                Date.from(Instant.EPOCH)
        );
        repository.save(professor);
    }

    public ProfessorDAO get(String id) {
        return repository.get(id);
    }

}
