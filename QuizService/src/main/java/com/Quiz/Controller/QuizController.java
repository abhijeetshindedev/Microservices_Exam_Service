package com.Quiz.Controller;

import com.Quiz.Entity.Quiz;
import com.Quiz.Services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

    private QuizServices quizServices;

    public QuizController(QuizServices quizServices) {
        this.quizServices = quizServices;
    }

    //save quiz
    @PostMapping(value = "/save")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        System.out.println("Quiz : "+quiz);
        return quizServices.add(quiz);
    }

    //get all quizzes
    @GetMapping()
    public List<Quiz> getQuizzes() {
        return quizServices.get();
    }

    //get quiz by id

    @GetMapping(value = "/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        System.out.println("id : "+id);
        return quizServices.get(id);
    }
}
