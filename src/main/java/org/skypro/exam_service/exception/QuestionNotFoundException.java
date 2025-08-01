package org.skypro.exam_service.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(String format) {
        super("Question not found");
    }
}