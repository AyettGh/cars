package com.fullstack.quizcars.classes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "version_id")
    private Version version;

    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    private Question parentQuestion;

    @OneToMany(mappedBy = "parentQuestion")
    private List<Question> subQuestions;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}
