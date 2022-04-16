package com.mongo.mongoDBTesting.Service;

import com.mongo.mongoDBTesting.Models.Users;
import com.mongo.mongoDBTesting.Repo.MongoRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private MongoRepo mongoRepo;
//    @Autowired
//    private Validator validator;

    public String addUser(Users user) {
//        Set<ConstraintViolation<Users>> violations =  validator.validate(user);
//        StringBuilder sb = new StringBuilder();
//        if(!violations.isEmpty()){
//            violations.stream().forEach(violation -> sb.append(violation.getMessage()));
//            throw new ConstraintViolationException("Error Ocurred: "+ sb.toString(),violations);
//        }
        mongoRepo.save(user);
        return "User" + user.getUserName() + "added successfully";
    }

    public Optional<Users> getUser(int userId) {
        Optional<Users> byId = mongoRepo.findById(userId);
        return byId;
    }

    public Page getUser() {
        Page byId = mongoRepo.findAll(PageRequest.ofSize(999));
        return byId;
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<?> getUser(@PathVariable("userId") int userId) {
//        Optional<Users> byId = mongoRepo.findAll(Pageable pa)
//        return new ResponseEntity<>(byId, HttpStatus.OK);
//    }
}
