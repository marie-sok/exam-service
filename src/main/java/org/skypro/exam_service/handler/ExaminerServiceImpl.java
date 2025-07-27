package org.skypro.exam_service.handler;

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
public class ExaminerServiceImpl implements ExamService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int totalQuestions = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (totalQuestions < amount) {
            throw new QuestionIllegalArgumentException("Not enough questions available");
        }

        Set<Question> questions = new HashSet<>();
        Random random = new Random();

        while (questions.size() < amount) {
            QuestionService service = random.nextBoolean() ? javaQuestionService : mathQuestionService;
            questions.add(service.getRandomQuestion());
        }

        return questions;
    }
}