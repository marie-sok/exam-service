package org.skypro.exam_service.impl;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.repository.MathQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MathQuestionServiceImpl {

    private final MathQuestionRepository repository;

    public MathQuestionServiceImpl(MathQuestionRepository repository) {
        this.repository = Objects.requireNonNull(repository, "Repository cannot be null");
    }

    public Question remove(Question question) {
        Objects.requireNonNull(question, "Question cannot be null");

        if (!repository.getAll().contains(question)) {
            throw new IllegalArgumentException("Question not found: " + question.getQuestion());
        }

        return repository.remove(question);
    }
}