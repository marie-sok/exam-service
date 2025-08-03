package org.skypro.exam_service.impl;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.stereotype.Service;
import repository.MathQuestionRepository;

import java.util.Collection;
import java.util.Objects;

@Service
public class MathQuestionImpl implements QuestionService {
    private final MathQuestionRepository repository;

    public MathQuestionImpl(MathQuestionRepository repository) {
        this.repository = Objects.requireNonNull(repository, "Repository cannot be null");
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        return repository.add(q);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        Objects.requireNonNull(question, "Question cannot be null");
        if (!repository.getAll().contains(question)) {
            throw new IllegalArgumentException("Question not found: " + question.getQuestion());
        }
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Question question = repository.getRandomQuestion();
        if (question == null) {
            throw new IllegalStateException("No math questions available");
        }
        return question;
    }
}