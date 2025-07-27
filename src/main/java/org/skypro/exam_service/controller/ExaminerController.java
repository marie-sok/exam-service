package org.skypro.exam_service.controller;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExaminerController {
    private final ExamService examService;

    public ExaminerController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examService.getQuestions(amount);
    }
}