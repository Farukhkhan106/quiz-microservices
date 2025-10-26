package com.token.quizserviceapplication.service;

import com.token.quizserviceapplication.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "QuestionServiceApplication")
public interface QuestionServiceClient {

    @GetMapping("/questions/{id}")
    Question getQuestionById(@PathVariable Long id);
}
