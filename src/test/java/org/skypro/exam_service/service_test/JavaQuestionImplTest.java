package org.skypro.exam_service.service_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.impl.JavaQuestionService;
import org.skypro.exam_service.model.Question;
import repository.QuestionRepository;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
class JavaQuestionImplTest {


    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private JavaQuestionService questionService;
    private Set<Question> questions;

    @BeforeEach
    public void beforeEach() {
        Question question1 = new Question("Java question 1", "Java answer 1");
        Question question2 = new Question("Java question 2", "Java answer 2");
        Question question3 = new Question("Java question 3", "Java answer 3");
        Question question4 = new Question("Java question 4", "Java answer 4");
    }
}