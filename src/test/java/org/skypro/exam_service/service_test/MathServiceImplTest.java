package org.skypro.exam_service.service_test;


import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.impl.MathQuestionService;
import repository.QuestionRepository;

import java.util.Set;

@ExtendWith(MockitoExtension.class)

public class MathServiceImplTest {

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
    }
}