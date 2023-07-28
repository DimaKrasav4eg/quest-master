package com.github.DimaKrasav4eg.questmaster.repository;

import com.github.DimaKrasav4eg.questmaster.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByActiveTrue();
}
