package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.Repository.UserRepository;
import com.fullstack.quizcars.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean existById(Long id) {
        return userRepository.existsById(id);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
