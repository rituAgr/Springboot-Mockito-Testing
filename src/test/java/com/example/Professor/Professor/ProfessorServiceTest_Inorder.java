package com.example.Professor.Professor;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorServiceTest_Inorder {

    @Mock
    private ProfessorRepository repository;

    @InjectMocks
    private ProfessorService professorService;


    @Test
    public void dummyMethodTest_Inorder(){

        InOrder inOrder = inOrder(repository);
        professorService.Dummy_method_toTest_Inorder("1");

        inOrder.verify(repository).get("1");
        inOrder.verify(repository).save(any(ProfessorDAO.class));


    }
}
