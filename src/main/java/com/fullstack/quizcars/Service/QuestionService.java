package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.Repository.QuestionRepository;
import com.fullstack.quizcars.classes.Question;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionService {
    @Autowired
    private com.fullstack.quizcars.Repository.QuestionRepository QuestionRepository;

    public List<Question> getQuestion() {
        return QuestionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id){
        return QuestionRepository.findById(id);
    }

    public  Question save(Question Question){
        return QuestionRepository.saveAndFlush(Question);}
    public  boolean existById(Long id){ return QuestionRepository.existsById(id);}
    public  void deleteQuestion(Long id){
        QuestionRepository.deleteById(id);
    }
}
