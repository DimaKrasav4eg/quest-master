package com.github.DimaKrasav4eg.questmaster.service;

import com.github.DimaKrasav4eg.questmaster.repository.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Service for handling {@link User} entity
 */
public interface UserService {
    /**
     * save {@link User} entity
     * @param user the {@link User} that should be saved
     */
    void save(User user);

    /**
     * Extract all active {@link User}
     * @return {@link List} of the active {@link User}
     */
    List<User> extractAllActiveUsers();

    /**
     * Find {@link User} by id
     * @param chatId - searched {@link User} chat id
     * @return {@link User} with provided chat id or null otherwise.
     */
    Optional<User> findByChatId(Long chatId);
}
