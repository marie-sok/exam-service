package repository;

import model.Question;

import java.util.Collection;
public interface QuestionRepository {
    public Question add(String question, String answer);
    public Question remove(Question question);
    public Collection<Question> getAll();
    default Question getRandomQuestion() {
        return null;
    }
}