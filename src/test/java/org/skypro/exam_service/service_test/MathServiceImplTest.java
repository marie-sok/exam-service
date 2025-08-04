package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.impl.MathQuestionImpl;
import org.skypro.exam_service.model.Question;
import repository.MathQuestionRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathServiceImplTest {

    @Mock
    private MathQuestionRepository repository;

    @InjectMocks
    private MathQuestionImpl questionService;

    private Question question1;
    private Question question2;

    @BeforeEach
    public void beforeEach() {
        question1 = new Question("Math question 1", "Math answer 1");
        question2 = new Question("Math question 2", "Math answer 2");
    }

    @Test
    void add_shouldCallRepository() {
        when(repository.add(question1)).thenReturn(question1);
        Question result = questionService.add(question1);
        assertEquals(question1, result);
        verify(repository).add(question1);
    }

    @Test
    void remove_shouldCallRepository() {
        when(repository.getAll()).thenReturn(Set.of(question1));
        when(repository.remove(question1)).thenReturn(question1);
        Question result = questionService.remove(question1);
        assertEquals(question1, result);
        verify(repository).remove(question1);
    }
}
