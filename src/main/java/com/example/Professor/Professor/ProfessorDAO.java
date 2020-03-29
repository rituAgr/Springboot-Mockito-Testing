package com.example.Professor.Professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDAO {
    String id;

    String name;

    int NumberClassesPerCourse;

    Date date;

}
