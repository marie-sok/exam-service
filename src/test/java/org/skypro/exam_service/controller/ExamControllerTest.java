package org.skypro.exam_service.controller;

import org.skypro.exam_service.exception.QuestionIllegalArgumentException;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.ExamService;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExamControllerTest implements ExamService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExamControllerTest(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        validateQuestionAmount(amount);
        return generateRandomQuestions(amount);
    }

    private void validateQuestionAmount(int amount) {
        int totalAvailableQuestions = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();

        if (amount <= 0) {
            throw new QuestionIllegalArgumentException("Requested amount must be positive");
        }

        if (totalAvailableQuestions < amount) {
            throw new QuestionIllegalArgumentException(
                    String.format("Not enough questions available. Requested: %d, Available: %d",
                            amount, totalAvailableQuestions)
            );
        }
    }

    private Collection<Question> generateRandomQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        Random random = new Random();

        while (questions.size() < amount) {
            QuestionService selectedService = random.nextBoolean()
                    ? javaQuestionService
                    : mathQuestionService;

            questions.add(selectedService.getRandomQuestion());
        }

        return questions;
    }
}