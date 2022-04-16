package com.mongo.mongoDBTesting.Repo;

import com.mongo.mongoDBTesting.Models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MongoRepo extends MongoRepository<Users, Integer> , PagingAndSortingRepository<Users,Integer> {

}
