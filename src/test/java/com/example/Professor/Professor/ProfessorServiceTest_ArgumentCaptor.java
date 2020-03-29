package com.example.Professor.Professor;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ProfessorServiceTest_ArgumentCaptor {

    @Mock
    private ProfessorRepository repository;

    @InjectMocks
    private ProfessorService professorService;


    @Test
    public void test(){

        ArgumentCaptor<ProfessorDAO> professorDaoCaptor = ArgumentCaptor.forClass(ProfessorDAO.class);
        ProfessorRequest request = new ProfessorRequest("id", "name", 12);

        professorService.add(request);
        ProfessorDAO professorDAO = new ProfessorDAO("id", "name", 12, new Date());

//        Verifying
        verify(repository).save(professorDaoCaptor.capture());
//        Asserting value
        assertThat(professorDaoCaptor.getValue()).isEqualTo(professorDAO);
    }

}
