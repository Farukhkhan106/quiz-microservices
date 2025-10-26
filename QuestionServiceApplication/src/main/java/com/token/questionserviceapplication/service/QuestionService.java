

package com.token.questionserviceapplication.service;

import com.token.questionserviceapplication.entity.Question;
import com.token.questionserviceapplication.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question addQuestion(Question question) {
        return repository.save(question);
    }

    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    public Optional<Question> getQuestionById(Long id) {
        return repository.findById(id);
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {
        updatedQuestion.setId(id);
        return repository.save(updatedQuestion);
    }

    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }
}
