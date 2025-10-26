package com.token.quizserviceapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long questionId; // reference to question-service

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore   // ✅ Add this to stop recursion
    private Quiz quiz;
}
