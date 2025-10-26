package com.token.quizserviceapplication.service;

import com.token.quizserviceapplication.entity.Quiz;
import com.token.quizserviceapplication.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return repository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return repository.findById(id);
    }
}
