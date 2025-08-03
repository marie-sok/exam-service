package org.skypro.exam_service.impl;

import org.skypro.exam_service.model.Question;
import org.skypro.exam_service.service.QuestionService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Primary
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = ConcurrentHashMap.newKeySet();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Objects.requireNonNull(question, "Question text cannot be null");
        Objects.requireNonNull(answer, "Answer cannot be null");

        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        Objects.requireNonNull(question, "Question cannot be null");
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        Objects.requireNonNull(question, "Question cannot be null");

        if (!questions.remove(question)) {
            throw new IllegalArgumentException(
                    String.format("Question not found: %s - %s",
                            question.getQuestion(), question.getAnswer())
            );
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("No Java questions available");
        }

        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(random.nextInt(questionList.size()));
    }
}