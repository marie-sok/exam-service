package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.impl.MathQuestionServiceImpl;
import org.skypro.exam_service.model.Question;
import repository.QuestionRepository;

import java.util.Set;

@ExtendWith(MockitoExtension.class)

public class MathServiceImplTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private MathQuestionServiceImpl questionService;
    private Set<Question> questions;
    private Assertions Assert;


    @BeforeEach
    public void beforeEach() {
        Question question1 = new Question("Math question 1", "Math answer 1");
        Question question2 = new Question("Math question 2", "Math answer 2");
        Question question3 = new Question("Math question 3", "Math answer 3");
        Question question4 = new Question("Math question 4", "Math answer 4");

    }
}