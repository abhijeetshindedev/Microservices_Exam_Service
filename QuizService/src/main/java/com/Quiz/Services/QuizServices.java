package com.Quiz.Services;

import com.Quiz.Entity.Quiz;

import java.util.List;

public interface QuizServices {
    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz get(long id);
    void delete(long id);
}
