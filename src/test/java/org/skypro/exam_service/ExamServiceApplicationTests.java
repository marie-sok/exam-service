package org.skypro.exam_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = {SomeConfiguration.class})
class ExamServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}

