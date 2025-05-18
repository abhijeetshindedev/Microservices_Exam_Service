package com.Quiz.Services.impl;

import com.Quiz.Entity.Quiz;
import com.Quiz.Repo.QuizRepo;
import com.Quiz.Services.QuestionClient;
import com.Quiz.Services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizServices {


    private QuizRepo quizRepo;

    private QuestionClient questionClient;

//    public QuizServiceImpl(QuizRepo quizRepo) {
//        this.quizRepo = quizRepo;
//    }

    public QuizServiceImpl(QuizRepo quizRepo, QuestionClient questionClient) {
        this.quizRepo = quizRepo;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepo.findAll();
        List<Quiz> newqQuizzes = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newqQuizzes;
    }

    @Override
    public Quiz get(long id) {
        Quiz quiz = quizRepo.findById(id).orElseThrow( () -> new RuntimeException("quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }

    @Override
    public void delete(long id) {
        Quiz quiz = quizRepo.findById(id).orElseThrow( () -> new RuntimeException("quiz not found"));
        quizRepo.delete(quiz);
    }
}
