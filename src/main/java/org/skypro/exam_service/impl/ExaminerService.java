package org.skypro.exam_service.impl;

import exception.QuestionIllegalArgumentException;
import model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerService implements service.ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    public ExaminerService(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                           @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size() + mathQuestionService.getAll().size() < amount) {
            throw new QuestionIllegalArgumentException();
        }
        Set<Question> randomQuestions = new HashSet<>();
        Random random = new Random();
        while (randomQuestions.size() < amount) {
            int questionRandom = random.nextInt(2);
            switch (questionRandom) {
                case 0:
                    randomQuestions.add(javaQuestionService.getRandomQuestion());
                    break;
                case 1:
                    randomQuestions.add(mathQuestionService.getRandomQuestion());
                    break;
            }
        }
        return randomQuestions;
    }
}