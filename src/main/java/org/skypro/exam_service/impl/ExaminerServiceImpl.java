package org.skypro.exam_service.impl;


import org.skypro.exam_service.exception.TooManyQuestionsRequestedException;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.ExamService;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExamService {
    private final QuestionService javaQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> allQuestions = javaQuestionService.getAll();

        if (amount > allQuestions.size()) {
            try {
                throw new TooManyQuestionsRequestedException();
            } catch (TooManyQuestionsRequestedException e) {
                throw new RuntimeException(e);
            }
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(javaQuestionService.getRandomQuestion());
        }

        return result;
    }
}