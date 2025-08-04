package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.exception.TooManyQuestionsException;
import org.skypro.exam_service.impl.ExamServiceImpl;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExamServiceImpl examinerService;

    @Test
    void getQuestionsTest() {
        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        when(questionService.getAll()).thenReturn(Set.of(q1, q2));
        when(questionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2);

        Collection<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
        assertTrue(result.contains(q1));
        assertTrue(result.contains(q2));
    }

    @Test
    void getQuestionsTooManyTest() {
        when(questionService.getAll()).thenReturn(Set.of(new Question("Q", "A")));
        assertThrows(TooManyQuestionsException.class, () -> {
            examinerService.getQuestions(2);
        });
    }
}
