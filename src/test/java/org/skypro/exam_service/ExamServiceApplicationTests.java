package org.skypro.exam_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.skypro.exam_service.service.ExamService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ExamServiceApplicationTests {

	@Autowired
	private ExamService examService;

	@Test
	void contextLoads() {

		assertThat(examService).isNotNull();
	}
}