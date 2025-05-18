package com.Quiz.Services;

import com.Quiz.Entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8082", name = "Question-Client")
public interface QuestionClient {

    @GetMapping(value = "/que/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
