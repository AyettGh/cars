package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Question;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
