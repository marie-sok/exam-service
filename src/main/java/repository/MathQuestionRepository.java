package repository;

import org.skypro.exam_service.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public IntPredicate add(String s, String s1) {
        return null;
    }
}