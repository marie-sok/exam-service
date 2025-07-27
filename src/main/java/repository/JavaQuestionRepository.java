package repository;

import model.Question;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Random;
import java.util.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
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
    public Question getRandomQuestion() {
        List<String> list = List.of("");
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        String randomElement = list.get(randomIndex);
        System.out.println(randomElement);
        return null;
    }
}