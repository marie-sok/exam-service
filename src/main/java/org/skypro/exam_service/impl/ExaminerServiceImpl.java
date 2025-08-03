package org.skypro.exam_service.impl;

import org.skypro.exam_service.exception.TooManyQuestionsException;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.ExamService;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExamService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Collection<Question> allQuestions = questionService.getAll();
        if (amount > allQuestions.size()) {
            throw new TooManyQuestionsException(
                    "Requested " + amount + " questions, but only " + allQuestions.size() + " available"
            );
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }
}