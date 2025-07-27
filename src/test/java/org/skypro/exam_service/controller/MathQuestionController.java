package org.skypro.exam_service.controller;

import model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.QuestionService;

import java.util.Collection;

@RestController

public class MathQuestionController  {
    private final QuestionService service;
    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }
    @GetMapping("/math/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question newQuestion = new Question(question, answer);
        return service.remove(newQuestion);
    }
    @GetMapping("/math")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}