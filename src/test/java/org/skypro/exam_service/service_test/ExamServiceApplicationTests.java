package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.Test;
import org.skypro.exam_service.service.ExamApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(
        webEnvironment = WebEnvironment.RANDOM_PORT,
        classes = ExamApplication.class)
class ExamServiceApplicationTests {

    @Test
    void contextLoads() {

    }
}