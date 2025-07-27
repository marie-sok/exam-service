package org.skypro.exam_service.controller;

import model.Question;
import service.ExaminerService;

import java.util.Collection;


@RestController

public class ExaminerController {

    public final ExaminerService examinerService;
    private int amount;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    public Collection<Question> getQuestions(@PathVariable int amount){
        this.amount = amount;
        return examinerService.getQuestions(amount);
    }
}
