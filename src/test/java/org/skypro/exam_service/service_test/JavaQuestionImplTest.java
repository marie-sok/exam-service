package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.Test;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.JavaQuestionService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionImplTest {
    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    void addAndGetAllTest() {
        Question q1 = service.add("Q1", "A1");
        Question q2 = service.add("Q2", "A2");

        Collection<Question> all = service.getAll();
        assertEquals(2, all.size());
        assertTrue(all.contains(q1));
        assertTrue(all.contains(q2));
    }

    @Test
    void removeTest() {
        Question q = service.add("Q", "A");
        assertEquals(q, service.remove(q));
        assertEquals(0, service.getAll().size());
    }

    @Test
    void getRandomQuestionTest() {
        Question q1 = service.add("Q1", "A1");
        Question q2 = service.add("Q2", "A2");

        Question random = service.getRandomQuestion();
        assertTrue(random.equals(q1) || random.equals(q2));
    }
}
