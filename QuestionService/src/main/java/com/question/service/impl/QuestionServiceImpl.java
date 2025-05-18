package com.question.service.impl;

import com.question.Entity.Question;
import com.question.Repo.QuestionRepo;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;


    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Question que = questionRepo.findById(question.getQuestionId()).orElseThrow(() -> new RuntimeException("Question not found"));
        que.setQuestion(question.getQuestion());
        return questionRepo.save(que);
    }

    @Override
    public Question getQuestion(long questionId) {
        return questionRepo.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public void deleteQuestion(long questionId) {
        questionRepo.deleteById(questionId);
    }

    @Override
    public List<Question> findByQuizId(long quizId) {
        return questionRepo.findByQuizId(quizId);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
}
