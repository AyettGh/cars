package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fullstack.quizcars.Repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizService {
    @Autowired
   private QuizRepository QuizRepository;

    public List<Quiz> getQuiz() {
        return QuizRepository.findAll();
    }

    public  Optional<Quiz> getQuizById(Long id){
        return QuizRepository.findById(id);
    }

    public  Quiz save(Quiz quiz){
        return QuizRepository.saveAndFlush(quiz);}
    public  boolean existById(Long id){ return QuizRepository.existsById(id);}
    public  void deleteQuiz(Long id){
        QuizRepository.deleteById(id);
    }
}
