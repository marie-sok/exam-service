package org.skypro.exam_service.impl;

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
public class ExaminerService implements ExamService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerService(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        validateAmount(amount);
        return getRandomQuestions(amount);
    }

    private void validateAmount(int amount) {
        int totalQuestions = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount <= 0) {
            throw new QuestionIllegalArgumentException("Amount must be positive");
        }
        if (totalQuestions < amount) {
            throw new QuestionIllegalArgumentException(
                    String.format("Requested %d questions, but only %d available", amount, totalQuestions)
            );
        }
    }

    private Collection<Question> getRandomQuestions(int amount) {
        Set<Question> randomQuestions = new HashSet<>();
        Random random = new Random();

        while (randomQuestions.size() < amount) {
            QuestionService service = random.nextBoolean()
                    ? javaQuestionService
                    : mathQuestionService;
            randomQuestions.add(service.getRandomQuestion());
        }

        return randomQuestions;
    }
}