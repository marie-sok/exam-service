package org.skypro.exam_service.repository;

import org.junit.Test;
import org.skypro.exam_service.model.Question;
import repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class JavaQuestionRepositoryTest {
    private JavaQuestionRepository repository;
    private final Question question1 = new Question("Q1", "A1");
    private final Question question2 = new Question("Q2", "A2");

    @Test
    public void add_shouldAddQuestionAndReturnIt() {
        Question result = repository.add(question1);
        assertEquals(question1, result);
        assertTrue(repository.getAll().contains(question1));
    }

    @Test
    public void add_shouldThrowWhenNull() {
        assertThrows(NullPointerException.class, () -> repository.add(null));
    }

    @Test
    public void remove_shouldRemoveQuestionAndReturnIt() {
        repository.add(question1);
        Question result = repository.remove(question1);
        assertEquals(question1, result);
        assertFalse(repository.getAll().contains(question1));
    }

    @Test
    public void remove_shouldThrowWhenQuestionNotExists() {
        assertThrows(NoSuchElementException.class, () -> repository.remove(question1));
    }

    @Test
    public void remove_shouldThrowWhenNull() {
        assertThrows(NullPointerException.class, () -> repository.remove(null));
    }

    @Test
    public void getAll_shouldReturnUnmodifiableCollection() {
        repository.add(question1);
        Collection<Question> result = repository.getAll();
        assertThrows(UnsupportedOperationException.class, () -> result.add(question2));
    }

    @Test
    public void getRandomQuestion_shouldReturnQuestionWhenExists() {
        repository.add(question1);
        repository.add(question2);

        Question result = repository.getRandomQuestion();
        assertTrue(result.equals(question1) || result.equals(question2));
    }

    @Test
    public void getRandomQuestion_shouldThrowWhenEmpty() {
        assertThrows(NoSuchElementException.class, () -> repository.getRandomQuestion());
    }
}