package org.skypro.exam_service.controller;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
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

    @GetMapping("")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}