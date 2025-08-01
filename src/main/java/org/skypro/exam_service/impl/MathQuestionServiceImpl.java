package org.skypro.exam_service.impl;

import org.skypro.exam_service.exception.QuestionNotFoundException;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        Objects.requireNonNull(question, "Question cannot be null");

        if (!questions.contains(question)) {
            throw new QuestionNotFoundException(String.format(
                    "Question '%s' with answer '%s' not found in repository",
                    question.getQuestion(),
                    question.getAnswer()
            ));
        }

        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return List.of();
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}