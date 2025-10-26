package com.token.quizserviceapplication.entity;

import lombok.Data;

@Data
public class Question {
    private Long id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;
}
