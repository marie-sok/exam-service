package org.skypro.exam_service.exception;

import org.skypro.exam_service.exception.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(QuestionIllegalArgumentException.HttpStatus.BAD_REQUEST)

public class QuestionIllegalArgumentException extends RuntimeException {

    public QuestionIllegalArgumentException() {
    }
}