package com.intraway.fizzbuzz.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.*;
import java.util.List;
import java.util.*;
import java.time.*;
import java.time.format.*; 


import com.intraway.fizzbuzz.models.UserModel;
import com.intraway.fizzbuzz.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




@RestController
@RequestMapping(value = "/fizzbuzz")
public class UserController {
    @Autowired
    UserServices UserServices;
    /*@GetMapping(path = "/{ini}/{end}")  
    public ResponseEntity<ArrayList> Registros(@PathVariable Integer ini,@PathVariable Integer end,@PathVariable("id") Long id){
        ArrayList array1 = new ArrayList();
        array1.add(ini);
        array1.add(end);
        IntStream streamer = IntStream.rangeClosed(ini,end);
        streamer.mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i)).forEach(array1::add);
        Long number = UserServices.conteoId();
        array1.add(number);
        return new ResponseEntity<>(array1,HttpStatus.OK);
    }*/

   /*public ArrayList<UserModel> obtenerRegistros(@PathVariable Integer ini,@PathVariable Integer end){
        UserModel request = new UserModel();
        UserModel.setDescription("test");
        UserRepositories.save(request);
        return UserServices.obtenerRegistros();
    }*/
    /*@GetMapping(path = "/{ini}/{end}")  
    public Optional<UserModel> obtenerUltRegistro(@PathVariable("id") Long id,@PathVariable Integer ini,@PathVariable Integer end){
        Long number = UserServices.conteoId();
        ArrayList array1 = new ArrayList();
        IntStream streamer = IntStream.rangeClosed(ini,end);
        streamer.mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i)).forEach(array1::add); 
        UserModel registroDato =  new UserModel();
        registroDato.setCode(number);
        return this.UserServices.obtenerUltimoRegistro(number);
    }*/


    /*public ResponseEntity<UserModel> obtenerRegistros(@PathVariable Integer ini,@PathVariable Integer end){  
        ini = ini+end;  
        return new ResponseEntity<>(ini,HttpStatus.OK);
    }*/

    /*@PostMapping()
    public UserModel guardarRegistro(@RequestBody UserModel fizzbuzz){
        
        return this.UserServices.guardarRegistro(fizzbuzz);
    }*/
    @GetMapping(path = "/{ini}/{end}")  
    public UserModel guardarRegistro(@PathVariable Integer ini,@PathVariable Integer end){
        Long number = UserServices.conteoId();
        LocalDateTime tiempoget = UserServices.LocalTime();

        IntStream streamer = IntStream.rangeClosed(ini,end);
        String resultado = streamer.mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : Integer.toString(i))).collect(Collectors.joining(","));
        
        Integer busquedafizz = resultado.indexOf("Fizz");
        Integer busquedabuzz = resultado.indexOf("Buzz");
        String descrip = new String();
        
        if(busquedafizz == - 1) {
            if(busquedabuzz == - 1){
                descrip = "No hay multiplos de 3 ni de 5";
            }else{
                descrip = "Hay multiplos de 5";
            }
         } else {
            if(busquedabuzz == - 1){
                descrip = "Hay multiplos de 3";
            }else{
                descrip = "Hay multiplos de 3 y de 5";
            }
         }

        UserModel registroDato =  new UserModel();
        registroDato.setCode(number+1);
        registroDato.setMin(ini);
        registroDato.setMax(end);
        registroDato.setDatetime(tiempoget);
        registroDato.setList(resultado);
        registroDato.setDescription(descrip);
        return this.UserServices.guardarRegistro(registroDato);
    }

}