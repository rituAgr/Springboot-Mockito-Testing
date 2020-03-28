package com.example.Professor.Professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorRequest {

    @NotEmpty
    String id;

    @Size(min = 1,max = 5)
    String name;

    @Min(2)
    @Max(5)
    int NumberClassesPerCourse;

}
