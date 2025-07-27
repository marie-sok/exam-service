package controller;

import model.Question;
import org.skypro.exam_service.controller.GetMapping;
import org.skypro.exam_service.controller.RequestParam;
import org.skypro.exam_service.controller.RestController;
import service.QuestionService;

import java.util.Collection;

@RestController
@GetMapping("/exam")
public class JavaQuestionController {

    public final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return service.add(question,answer);
    }
    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question newQuestion = new Question(question, answer);
        return service.remove(newQuestion);
    }
    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
