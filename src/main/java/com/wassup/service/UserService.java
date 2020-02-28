package com.wassup.service;

import com.wassup.domain.model.User;
import com.wassup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insert(final User user) {
        userRepository.save(user);
    }

    public User getUserByEmail(final String email) {
        return userRepository.findById(email).orElseGet(null);
    }

    public void addUser(final String email, final User newUser) {
        final Optional<User> optionalUser = userRepository.findById(email);
        final User userById = optionalUser.get();

        userById.getContacts().add(newUser);

        userRepository.save(userById);

    }

}
