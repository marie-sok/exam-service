package org.skypro.exam_service.repository_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.impl.MathQuestionImpl;
import org.skypro.exam_service.model.Question;
import repository.MathQuestionRepository;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionRepositoryTest {

    @Mock
    private MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    private MathQuestionImpl mathQuestionService;

    private final Question question = new Question("2+2?", "4");


    @Test
    void removeQuestion_WhenNotExists_ShouldThrowException() {

        when(mathQuestionRepository.getAll()).thenReturn(Collections.emptySet());


        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> mathQuestionService.remove(question));

        assertEquals("Question not found: 2+2?", exception.getMessage());
        verify(mathQuestionRepository, times(1)).getAll();
        verify(mathQuestionRepository, never()).remove(any());
    }

    @Test
    void removeQuestion_WhenExists_ShouldRemove() {

        when(mathQuestionRepository.getAll()).thenReturn(Set.of(question));
        when(mathQuestionRepository.remove(question)).thenReturn(question);


        Question result = mathQuestionService.remove(question);


        assertSame(question, result);
        verify(mathQuestionRepository, times(1)).getAll();
        verify(mathQuestionRepository, times(1)).remove(question);
    }
}
