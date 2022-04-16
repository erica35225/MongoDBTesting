package com.mongo.mongoDBTesting.Controller;

import com.mongo.mongoDBTesting.Models.Users;
import com.mongo.mongoDBTesting.Repo.MongoRepo;
import com.mongo.mongoDBTesting.Service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String addUser(@RequestBody @Valid Users user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId") int userId) {
        return new ResponseEntity<>( userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        Page byId = userService.getUser();
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<?> getUser(@PathVariable("userId") int userId) {
//        Optional<Users> byId = mongoRepo.findAll(Pageable pa)
//        return new ResponseEntity<>(byId, HttpStatus.OK);
//    }
}
