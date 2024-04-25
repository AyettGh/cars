package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.Service.QuizService;
import com.fullstack.quizcars.classes.Quiz;
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
public class QuizController {
    @Autowired

    private QuizService QuizService;
    @GetMapping("/Quiz")
    public List<Quiz> getQuiz()
    {
        return QuizService.getQuiz();
    }

    @GetMapping("/Quiz/{id}")
    public Quiz getQuiz(@PathVariable long id){
        return QuizService.getQuizById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Quiz")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return QuizService.save(quiz);
    }
    @PutMapping("/Quiz/{id}")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz Quiz , @PathVariable Long id){
        if( QuizService.existById(id)){
            Quiz Quiz1 =QuizService.getQuizById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            Quiz1.setTitle(Quiz.getTitle());
            //Quiz1.setQuestions(Quiz.getQuestions());

            QuizService.save(Quiz);
            return ResponseEntity.ok().body(Quiz1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Quiz/{id}")
    public ResponseEntity<?> deleteQuiz(@RequestBody Quiz Quiz ,@PathVariable Long id){
        if( QuizService.existById(id)){
            QuizService.deleteQuiz(id);
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
