package org.skypro.exam_service.repository;

import org.skypro.exam_service.model.Question;

import java.util.Collection;

public interface MathQuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}