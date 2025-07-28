package org.skypro.exam_service.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
        super("Question not found");
    }
}