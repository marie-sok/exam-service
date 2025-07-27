package service;

import model.Question;

import java.util.Collection;

public interface QuestionService {
    public static String greet(String name) {
        if (name == null || name.isEmpty()) {
            return ("Hello,Anonym");
        }
        return ("Hello, " + name);

    }
    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question>getAll();

    public Question getRandomQuestion();
}

