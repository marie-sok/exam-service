package org.skypro.exam_service.repository_test;


import model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.exception.QuestionNotFoundException;
import org.skypro.exam_service.impl.MathQuestionService;
import repository.MathQuestionRepository;
import repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static service.QuestionService.greet;

@ExtendWith(MockitoExtension.class)

class MathQuestionRepositoryTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private MathQuestionService questionService;
    private Set<Question> questions;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private org.junit.jupiter.api.Assertions Assert;
    @BeforeEach
    public void beforeEach() {
        question1 = new Question("Math question 1", "Math answer 1");
        question2 = new Question("Math question 2", "Math answer 2");
        question3 = new Question("Math question 3", "Math answer 3");
        question4 = new Question("Math question 4", "Math answer 4");
        questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }
    @Test
    void whenNameIsGiven() {
        String name = "Test";
        Assert.assertEquals("Hello, Test", greet(name));
    }
    @Test
    void whenNameIsNull() {
        String name = null;
        Assert.assertEquals("Hello, Anonym",greet(name));
    }
    @Test
    void whenNameIsEmpty() {
        String name = "";
        Assert.assertEquals("Hello, Anonymous", MathQuestionRepository.greet(name));
    }
    @Test
    public void addTest() {
        when(repository.add(question4.getQuestion(), question4.getAnswer())).thenReturn(question4);
        Assertions.assertThat(questionService.add(question4.getQuestion(), question4.getAnswer())).isEqualTo(question4);
    }
    @Test
    public void removeTest() {
        when(repository.getAll()).thenReturn(questions);
        when(repository.remove(question1)).thenReturn(question1);
        Assertions.assertThat(questionService.remove(question1)).isEqualTo(question1);
    }
    @Test
    public void removeWhenNotFoundTest() {
        when(repository.getAll()).thenReturn(questions);
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(question4));
    }
    @Test
    public void getAllTest() {
        when(repository.getAll()).thenReturn(questions);
        Assertions.assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Math question 1", "Math answer 1"),
                        new Question("Math question 2", "Math answer 2"),
                        new Question("Math question 3", "Math answer 3")
                );
    }
}
