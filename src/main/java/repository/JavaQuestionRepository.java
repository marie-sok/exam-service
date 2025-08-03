package repository;

import org.skypro.exam_service.model.Question;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JavaQuestionRepository {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new NoSuchElementException("Question not found");
        }
        return question;
    }

    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NoSuchElementException("No questions available");
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}