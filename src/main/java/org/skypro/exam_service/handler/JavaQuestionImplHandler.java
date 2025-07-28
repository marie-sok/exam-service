package org.skypro.exam_service.handler;

import org.skypro.exam_service.exception.QuestionNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JavaQuestionImplHandler {

    @ExceptionHandler(QuestionNotFoundException.class)
    public String removeWhenQuestionNotFoundException() {
        return "Question is not found";
    }
}