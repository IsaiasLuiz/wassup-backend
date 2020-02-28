package com.wassup.service;

import com.wassup.domain.model.Contact;
import com.wassup.domain.model.User;
import com.wassup.repository.ContactRepository;
import com.wassup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private ContactRepository contactRepository;

    @Autowired
    public UserService(final UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    public void insert(final User user) {
        userRepository.save(user);
    }

    public User getUserByEmail(final String email) {
        return userRepository.findById(email).get();
    }

    public void addUser(final String email, final Contact newUser) {
        final Optional<User> optionalUser = userRepository.findById(email);
        final User userById = optionalUser.get();

        contactRepository.save(newUser);

        userById.getContacts().add(newUser);

        userRepository.save(userById);

    }

}
