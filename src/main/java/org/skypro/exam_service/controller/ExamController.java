package org.skypro.exam_service.controller;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examService.getQuestions(amount);
    }
}