package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.exception.TooManyQuestionsException;
import org.skypro.exam_service.impl.ExaminerServiceImpl;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService javaQuestionService;

    @Mock
    private QuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestion() {

        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        when(javaQuestionService.getAll()).thenReturn(Set.of(q1));
        when(mathQuestionService.getAll()).thenReturn(Set.of(q2));
        when(javaQuestionService.getRandomQuestion()).thenReturn(q1);
        when(mathQuestionService.getRandomQuestion()).thenReturn(q2);


        Collection<Question> result = examinerService.getQuestions(1);


        assertEquals(1, result.size());
    }

    @Test
    void getQuestions_shouldThrowWhenNotEnoughQuestions() {

        when(javaQuestionService.getAll()).thenReturn(Set.of());
        when(mathQuestionService.getAll()).thenReturn(Set.of());


        assertThrows(TooManyQuestionsException.class,
                () -> examinerService.getQuestions(1));
    }

    @Test
    void getQuestions_shouldReturnUniqueQuestions() {

        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        when(javaQuestionService.getAll()).thenReturn(Set.of(q1, q2));
        when(mathQuestionService.getAll()).thenReturn(Set.of());
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2);


        Collection<Question> result = examinerService.getQuestions(2);


        assertEquals(2, result.size());
        assertTrue(result.contains(q1));
        assertTrue(result.contains(q2));
    }
}