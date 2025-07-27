package org.skypro.exam_service.service_test;

import impl.JavaQuestionService;
import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.QuestionRepository;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {


    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private JavaQuestionService questionService;
    private Set<Question> questions;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;

    @BeforeEach
    public void beforeEach() {
        question1 = new Question("Java question 1", "Java answer 1");
        question2 = new Question("Java question 2", "Java answer 2");
        question3 = new Question("Java question 3", "Java answer 3");
        question4 = new Question("Java question 4", "Java answer 4");
    }
}