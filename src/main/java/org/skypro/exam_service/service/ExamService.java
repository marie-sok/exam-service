package org.skypro.exam_service.service;

import org.skypro.exam_service.model.Question;

import java.util.Collection;

public interface ExamService {
    Collection<Question> getQuestions(int amount);
}