package org.skypro.exam_service.handler;

import org.skypro.exam_service.exception.QuestionIllegalArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;
@RestControllerAdvice
public class ExaminerServiceImplHandler {
    private final int examinerServiceImplHandler;

    public ExaminerServiceImplHandler(int examinerServiceImplHandler) {
        this.examinerServiceImplHandler = examinerServiceImplHandler;
    }

    @ExceptionHandler(QuestionIllegalArgumentException.class)
    public ResponseEntity<String> handleException(Exception e) {
        String errorUUID = logErrorToNoSql(e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Number of request exceeded " + e.getMessage());
    }

    private String logErrorToNoSql(Exception e) {
        return UUID.randomUUID().toString();
    }

    public int getPower() {
        return 0;
    }

    @RestControllerAdvice
    static class JavaQuestionImplHandler {

        public JavaQuestionImplHandler(String service, ExaminerServiceImplHandler examinerServiceImplHandler) {
        }
    }
}