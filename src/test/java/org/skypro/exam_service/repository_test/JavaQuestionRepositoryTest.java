package org.skypro.exam_service.repository_test;

import model.Question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.JavaQuestionRepository;
import repository.QuestionRepository;

public class JavaQuestionRepositoryTest {


    private final QuestionRepository questionRepository = new JavaQuestionRepository();

    @BeforeEach
    public void beforeEach() {
        questionRepository.add("Java question 1", "Java answer 1");
        questionRepository.add("Java question 2", "Java answer 2");
        questionRepository.add("Java question 3", "Java answer 3");
    }
    @AfterEach
    public void afterEach() {
        questionRepository.getAll().stream()
                .map(e -> questionRepository.remove(e));
    }
    @Test
    public void addTest() {
        int beforeCount = questionRepository.getAll().size();
        Question expected = new Question("Java question 4", "Java answer 4");
        Assertions.assertThat(questionRepository.add("Java question 4", "Java answer 4")).isEqualTo(expected)
                .isIn(questionRepository.getAll());
        Assertions.assertThat(questionRepository.getAll()).hasSize(beforeCount + 1);
    }
    @Test
    public void removeTest() {
        int beforeCount = questionRepository.getAll().size();
        Question expected = new Question("Java question 1", "Java answer 1");
        Assertions.assertThat(questionRepository.remove(new Question("Java question 1", "Java answer 1"))).isEqualTo(expected)
                .isNotIn(questionRepository.getAll());
        Assertions.assertThat(questionRepository.getAll()).hasSize(beforeCount - 1);
    }
    @Test
    public void getAllTest() {
        Assertions.assertThat(questionRepository.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Java question 1", "Java answer 1"),
                        new Question("Java question 2", "Java answer 2"),
                        new Question("Java question 3", "Java answer 3")
                );
    }
}