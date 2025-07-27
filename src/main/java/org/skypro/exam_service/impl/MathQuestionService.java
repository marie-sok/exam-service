package org.skypro.exam_service.impl;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionService implements QuestionService {
    private final QuestionService questionService;

    public MathQuestionService(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @DeleteMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
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