package org.skypro.exam_service.impl;

import org.skypro.exam_service.exception.QuestionNotFoundException;
import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.stereotype.Service;
import repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository repository;

    public JavaQuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        if (!repository.getAll().contains(question)) {
            throw new QuestionNotFoundException("Question not found");
        }
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = repository.getAll();
        int item = new Random().nextInt(questions.size());
        return (Question) questions.toArray()[item];
    }
}