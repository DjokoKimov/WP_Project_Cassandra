package com.cassandradb.springbootcassandra.controller;

import com.cassandradb.springbootcassandra.model.User;
import com.cassandradb.springbootcassandra.repository.UserRepository;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void saveUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Djoko", "Kimov", 13000));
        users.add(new User(2, "Tashko", "Pavlov", 20000));
        users.add(new User(3, "Toshe", "Todorov", 18000));
        users.add(new User(4, "Test", "Test1", 18000));
        userRepository.saveAll(users);
    }

    @GetMapping("/showAllUsers")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getUsersBySalary/{salary}")
    public List<User> getUsersFilterBySalaryGreater(@PathVariable int salary) {
        return userRepository.findBySalaryGreaterThan(salary);
    }


}
