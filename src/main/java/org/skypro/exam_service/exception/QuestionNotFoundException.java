package org.skypro.exam_service.exception;

public class QuestionNotFoundException extends RuntimeException {

    public QuestionNotFoundException() {
        System.out.println("Message for user");
    }
}