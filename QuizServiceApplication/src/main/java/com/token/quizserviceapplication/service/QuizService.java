package com.token.quizserviceapplication.service;

import com.token.quizserviceapplication.entity.Question;
import com.token.quizserviceapplication.entity.Quiz;
import com.token.quizserviceapplication.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository repository;
    private final QuestionServiceClient questionClient;

    public QuizService(QuizRepository repository, QuestionServiceClient questionClient) {
        this.repository = repository;
        this.questionClient = questionClient;
    }

    public Quiz createQuiz(Quiz quiz) {
        quiz.getQuestions().forEach(q -> q.setQuiz(quiz)); // ensures relation is saved
        return repository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = repository.findAll();

        quizzes.forEach(quiz -> {
            List<Question> fullQuestions = quiz.getQuestions().stream()
                    .map(qq -> questionClient.getQuestionById(qq.getQuestionId()))
                    .collect(Collectors.toList());
            quiz.setQuestionsFull(fullQuestions);
        });

        return quizzes;
    }

    public Optional<Quiz> getQuizById(Long id) {
        Optional<Quiz> quizOpt = repository.findById(id);
        quizOpt.ifPresent(quiz -> {
            List<Question> fullQuestions = quiz.getQuestions().stream()
                    .map(qq -> questionClient.getQuestionById(qq.getQuestionId()))
                    .collect(Collectors.toList());
            quiz.setQuestionsFull(fullQuestions);
        });
        return quizOpt;
    }
}
