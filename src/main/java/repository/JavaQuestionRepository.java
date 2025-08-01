package repository;

import org.skypro.exam_service.model.Question;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public  class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new NoSuchElementException("Question not found");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.stream()
                .skip(random.nextInt(questions.size()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No questions available"));
    }
}