package com.question.service;

import com.question.Entity.Question;

import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    Question updateQuestion(Question question);
    Question getQuestion(long questionId);
    void deleteQuestion(long questionId);

    List<Question> findByQuizId(long quizId);
    List<Question> getAllQuestions();
}
