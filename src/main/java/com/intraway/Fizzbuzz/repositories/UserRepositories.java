package com.intraway.fizzbuzz.repositories;

import java.util.ArrayList;

import com.intraway.fizzbuzz.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends CrudRepository<UserModel,Long>{
        
}