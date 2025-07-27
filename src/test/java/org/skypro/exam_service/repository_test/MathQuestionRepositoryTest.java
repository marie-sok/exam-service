package org.skypro.exam_service.repository_test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam_service.exception.QuestionNotFoundException;
import org.skypro.exam_service.impl.MathQuestionService;
import org.skypro.exam_service.model.Question;
import repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

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

    @BeforeEach
    public void setUp() {
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
    public void addQuestion_ShouldReturnAddedQuestion() {
        when(repository.add(question4)).thenReturn(question4);

        Question result = questionService.add(question4.getQuestion(), question4.getAnswer());

        Assertions.assertThat(result).isEqualTo(question4);
        verify(repository, times(1)).add(any(Question.class));
    }

    @Test
    public void removeQuestion_WhenExists_ShouldReturnRemovedQuestion() {
        when(repository.getAll()).thenReturn(questions);
        when(repository.remove(question1)).thenReturn(question1);

        Question result = questionService.remove(question1);

        Assertions.assertThat(result).isEqualTo(question1);
        verify(repository, times(1)).remove(question1);
    }

    @Test
    public void removeQuestion_WhenNotExists_ShouldThrowException() {
        when(repository.getAll()).thenReturn(questions);

        Assertions.assertThatThrownBy(() -> questionService.remove(question4))
                .isInstanceOf(QuestionNotFoundException.class)
                .hasMessageContaining("Question not found");

        verify(repository, never()).remove(question4);
    }

    @Test
    public void getAllQuestions_ShouldReturnAllQuestions() {
        when(repository.getAll()).thenReturn(questions);

        Set<Question> result = new HashSet<>(questionService.getAll());

        Assertions.assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(question1, question2, question3);
        verify(repository, times(1)).getAll();
    }

    @Test
    public void getRandomQuestion_ShouldReturnQuestionFromRepository() {
        when(repository.getAll()).thenReturn(Set.of(question1));

        Question result = questionService.getRandomQuestion();

        Assertions.assertThat(result).isEqualTo(question1);
        verify(repository, times(1)).getAll();
    }
}