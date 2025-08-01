package org.skypro.exam_service.impl;

import org.skypro.exam_service.exception.TooManyQuestionsException;
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
public class ExaminerServiceImpl implements ExamService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection <Question> getQuestions(int amount) {
        Set<Question> allQuestions = new HashSet<>();
        allQuestions.addAll(javaQuestionService.getAll());
        allQuestions.addAll(mathQuestionService.getAll());

        if (amount > allQuestions.size()) {
            throw new TooManyQuestionsException();
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            QuestionService service = random.nextBoolean() ? javaQuestionService : mathQuestionService;
            result.add(service.getRandomQuestion());
        }
        return result;
    }
}