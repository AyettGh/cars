package com.fullstack.quizcars.Controller;

import  com.fullstack.quizcars.Service.QuestionService;
import com.fullstack.quizcars.classes.Question;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/q")
public class QuestionController {
    @Autowired

    private QuestionService QuestionService;
    @GetMapping("/Question")
    public List<Question> getQuestion()
    {
        return QuestionService.getQuestion();
    }

    @GetMapping("/Question/{id}")
    public Question getQuestion(@PathVariable long id){
        return QuestionService.getQuestionById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Question")
    public Question addQuestion(@RequestBody Question Question){
        return QuestionService.save(Question);
    }
    @PutMapping("/Question/{id}")
    public ResponseEntity<?> addQuestion(@RequestBody Question Question , @PathVariable Long id){
        if( QuestionService.existById(id)){
            Question Question1 =QuestionService.getQuestionById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            Question1.setText(Question.getText());
//            Question1.setQuiz(Question.getQuiz());
//            Question1.setParentQuestion(Question.getParentQuestion());
//            Question1.setSubQuestions(Question.getSubQuestions());
//            Question1.setVersion(Question.getVersion());

            QuestionService.save(Question);
            return ResponseEntity.ok().body(Question1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Question/{id}")
    public ResponseEntity<?> deleteQuestion(@RequestBody Question Question ,@PathVariable Long id){
        if( QuestionService.existById(id)){
            QuestionService.deleteQuestion(id);
            HashMap<String,String> message=new HashMap<>();
            message.put("message",id+"deleted");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
