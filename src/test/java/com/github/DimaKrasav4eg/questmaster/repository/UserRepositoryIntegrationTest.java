package com.github.DimaKrasav4eg.questmaster.repository;

import com.github.DimaKrasav4eg.questmaster.repository.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/test-qmtb-db",
        "spring.datasource.username=qaqtus",
        "spring.datasource.password=qaqtus"})
class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql(scripts = {"/sql/clearAllDbs.sql", "/sql/addUsers.sql"})
    public void findAllActiveUsers(){
        List<User> activeUsers = this.userRepository.findAllByActiveTrue();

        Assertions.assertEquals(activeUsers.size(), 4);
    }

    @Test
    @Sql(scripts = {"/sql/clearAllDbs.sql"})
    public void saveUser(){
        long chatIdEx = 66606660666L;
        User user = new User();
        user.setChatId(chatIdEx);
        user.setActive(true);
        user.setTgTag("no_frozen_devil");
        this.userRepository.save(user);

        Optional<User> savedUser = this.userRepository.findById(chatIdEx);

        Assertions.assertTrue(savedUser.isPresent());
        Assertions.assertEquals(user, savedUser.get());
    }

}