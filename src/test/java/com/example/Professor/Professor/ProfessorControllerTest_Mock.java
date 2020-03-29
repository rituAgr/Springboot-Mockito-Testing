package com.example.Professor.Professor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorControllerTest_Mock {

    @Mock
    private ProfessorService professorService;

    @InjectMocks
    private ProfessorController professorController;

    //Normal condition where mock object returns what it is asked to return
    @Test
    public void getProfessorTest_success(){
        ProfessorDAO professorDAO = new ProfessorDAO("id", "name", 1, new Date());
        String id = "id";
        when(professorService.get(id)).thenReturn(professorDAO);

        ProfessorDAO result = professorController.getProfessor(id);

        Assert.assertEquals(result.id, id);
        Assert.assertEquals(result.name, "name");

    }

    //All mocks return null (or 0 in the case of primitives) unless specified to return something.
    @Test
    public void getProfessorTest_MockReturnNull(){
        String id = "id";

        ProfessorDAO result = professorController.getProfessor(id);

        Assert.assertEquals(result,null);
    }


    @Test
    public void addProfessorTest_Verify(){
        ProfessorRequest request = new ProfessorRequest("id", "name", 1);

        professorController.addProfessor(request);

//        Below are three ways to verify
//        verify(professorService, times(1)).add(request);
//        verify(professorService, times(1)).add(new ProfessorRequest("id", "name", 1));
        verify(professorService, times(1)).add(any(ProfessorRequest.class));
    }


}