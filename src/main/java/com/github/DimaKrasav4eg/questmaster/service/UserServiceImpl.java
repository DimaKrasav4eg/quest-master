package com.github.DimaKrasav4eg.questmaster.service;

import com.github.DimaKrasav4eg.questmaster.repository.UserRepository;
import com.github.DimaKrasav4eg.questmaster.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> extractAllActiveUsers() {
        return this.userRepository.findAllByActiveTrue();
    }

    @Override
    public Optional<User> findByChatId(Long chatId) {
        //TODO why Long instead of String?
        return this.userRepository.findById(chatId);
    }
}
