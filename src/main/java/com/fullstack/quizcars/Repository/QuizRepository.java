package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Quiz;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
