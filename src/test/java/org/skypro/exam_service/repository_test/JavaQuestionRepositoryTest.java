package org.skypro.exam_service.repository_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.exam_service.model.Question;
import repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private JavaQuestionRepository repository;
    private final Question question1 = new Question("Q1", "A1");
    private final Question question2 = new Question("Q2", "A2");

    @BeforeEach
    void setUp() {
        repository = new JavaQuestionRepository();
    }

    @Test
    void add_shouldAddQuestionAndReturnIt() {
        Question result = repository.add(question1);
        assertEquals(question1, result);
        assertTrue(repository.getAll().contains(question1));
    }

    @Test
    void remove_shouldRemoveQuestionAndReturnIt() {
        repository.add(question1);
        Question result = repository.remove(question1);
        assertEquals(question1, result);
        assertFalse(repository.getAll().contains(question1));
    }

    @Test
    void remove_shouldThrowWhenQuestionNotExists() {
        assertThrows(NoSuchElementException.class, () -> repository.remove(question1));
    }

    @Test
    void getAll_shouldReturnUnmodifiableCollection() {
        repository.add(question1);
        Collection<Question> result = repository.getAll();
        assertThrows(UnsupportedOperationException.class, () -> result.add(question2));
    }

    @Test
    void getRandomQuestion_shouldReturnQuestionWhenExists() {
        repository.add(question1);
        repository.add(question2);

        Question result = repository.getRandomQuestion();
        assertTrue(result.equals(question1) || result.equals(question2));
    }
}
