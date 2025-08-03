package org.skypro.exam_service.repository_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.impl.MathQuestionServiceImpl;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.repository.MathQuestionRepository;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionRepositoryTest {

    @Mock
    private MathQuestionRepository mathQuestionRepository;

    private MathQuestionServiceImpl mathQuestionService;

    @BeforeEach
    void setUp() {
        mathQuestionService = new MathQuestionServiceImpl(mathQuestionRepository);
    }

    @Test
    void removeQuestion_WhenNotExists_ShouldThrowException() {
        Question question = new Question("2+2?", "4");
        when(mathQuestionRepository.getAll()).thenReturn(Collections.emptySet());


        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> mathQuestionService.remove(question));

        assertTrue(exception.getMessage().contains("Question not found"));
        verify(mathQuestionRepository, times(1)).getAll();
        verify(mathQuestionRepository, never()).remove(any());
    }

    @Test
    void removeQuestion_WhenExists_ShouldRemove() {
        Question question = new Question("2+2?", "4");
        when(mathQuestionRepository.getAll()).thenReturn(Set.of(question));
        when(mathQuestionRepository.remove(question)).thenReturn(question);


        Question result = mathQuestionService.remove(question);


        assertSame(question, result);
        verify(mathQuestionRepository, times(1)).getAll();
        verify(mathQuestionRepository, times(1)).remove(question);
    }
}