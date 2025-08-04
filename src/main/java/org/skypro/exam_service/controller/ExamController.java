package org.skypro.exam_service.controller;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExamController {

    //endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "The app is working! Local actual time: " + java.time.LocalDateTime.now();
    }

    //endpoint
    @GetMapping("/status")
    public Map<String, String> getStatus() {
        return Map.of(
                "status", "working",
                "timestamp", LocalDateTime.now().toString()
        );
    }

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examService.getQuestions(amount);
    }
}
