package org.skypro.exam_service.repository_test;

import org.junit.jupiter.api.Test;
import org.skypro.exam_service.exception.QuestionNotFoundException;
import org.skypro.exam_service.impl.JavaQuestionService;
import org.skypro.exam_service.model.Question;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    void addQuestionTest() {
        Question question = service.add("Q1", "A1");
        assertTrue(service.getAll().contains(question));
    }

    @Test
    void removeQuestionTest() {
        Question question = service.add("Q2", "A2");
        Question removed = service.remove(question);
        assertEquals(question, removed);
        assertFalse(service.getAll().contains(question));
    }

    @Test
    void removeNonExistingQuestionTest() {
        assertThrows(QuestionNotFoundException.class,
                () -> service.remove(new Question("Q3", "A3")));
    }

    @Test
    void getRandomQuestionTest() {
        service.add("Q4", "A4");
        assertNotNull(service.getRandomQuestion());
    }
}