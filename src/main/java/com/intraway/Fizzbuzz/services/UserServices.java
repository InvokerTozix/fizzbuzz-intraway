package com.intraway.fizzbuzz.services;

import java.util.ArrayList;
import java.util.Optional;
import java.time.*;
import java.time.format.*; 

import com.intraway.fizzbuzz.models.UserModel;
import com.intraway.fizzbuzz.repositories.UserRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    UserRepositories UserRepositories;

    public ArrayList<UserModel> obtenerRegistros(){
        return (ArrayList<UserModel>) UserRepositories.findAll();
    }

    public UserModel guardarRegistro(UserModel fizzbuzz){
        return UserRepositories.save(fizzbuzz);
    }

    public Optional<UserModel> obtenerUltimoRegistro(Long id){
        return UserRepositories.findById(id);
    }

    public Long conteoId(){
        return UserRepositories.count();
    }

    public LocalDateTime LocalTime(){
        LocalDateTime tiempo = LocalDateTime.now();
        return tiempo;
    }

    
}