package com.example.Professor.Professor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


@RunWith(MockitoJUnitRunner.class)
public class ProfessorControllerTest_Spy {


    //Below way of spying doesn't work
//    @Spy
//    private ProfessorService professorService;

    //Any of below two ways of spying work
    private ProfessorService professorService = spy(ProfessorService.class);
//    private ProfessorService professorService = spy(new ProfessorService());

    @Autowired
    private ProfessorController controller=new ProfessorController(professorService);


    //Below unit test is example of spy with stubbing
    @Test
    public void getProfessor_success_spy(){

        //below line is called as stubbing the spy
        doReturn(new ProfessorDAO("id", "name", 12, new Date()))
                .when(professorService).get("id");

        ProfessorDAO result = controller.getProfessor("id");

        assertThat(result).isEqualTo(new ProfessorDAO("id", "name", 12, new Date()));
//        assertThat(result).isEqualTo(new ProfessorDAO(eq("id"), eq("name"), eq(12), any(Date.class)));

    }

    //Below unit test is example of spy without stubbing

    @Spy
    List<String> spyList = new ArrayList<>();

    @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());
    }

}
