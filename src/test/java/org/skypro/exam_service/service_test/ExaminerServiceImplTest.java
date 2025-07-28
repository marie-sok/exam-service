package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.exam_service.exception.TooManyQuestionsRequestedException;
import org.skypro.exam_service.impl.ExaminerServiceImpl;
import org.skypro.exam_service.impl.JavaQuestionService;
import org.skypro.exam_service.model.Question;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        examinerService = new ExaminerServiceImpl(javaQuestionService);

        // Добавляем тестовые вопросы
        javaQuestionService.add("Q1", "A1");
        javaQuestionService.add("Q2", "A2");
        javaQuestionService.add("Q3", "A3");
    }

    @Test
    void getQuestionsTest() {
        Collection<Question> questions = examinerService.getQuestions(2);
        assertEquals(2, questions.size());
    }

    @Test
    void getTooManyQuestionsTest() {
        assertThrows(TooManyQuestionsRequestedException.class,
                () -> examinerService.getQuestions(10));
    }

    @Test
    void getQuestionsReturnsUniqueQuestionsTest() {
        Collection<Question> questions = examinerService.getQuestions(3);
        assertEquals(3, new HashSet<>(questions).size());
    }
}