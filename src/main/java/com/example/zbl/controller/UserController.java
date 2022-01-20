package com.example.zbl.controller;


import com.example.zbl.entity.UserEntity;
import com.example.zbl.exeption.UserAlreadyExists;
import com.example.zbl.exeption.UserDontExist;
import com.example.zbl.repo.UserRepo;
import com.example.zbl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserEntity user){

        try{
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно добавлен");
        }catch (UserAlreadyExists г){
            return ResponseEntity.badRequest().body(г.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Пароль должен быть больше 8 символов");
        }
    }
    @GetMapping("/getUser")
    public ResponseEntity getUser(@RequestParam int id){

        try{

            return ResponseEntity.ok(userService.getUser(id));
        }catch (UserDontExist u){
            return ResponseEntity.badRequest().body(u.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Что-то пошло не так");
        }
    }




}
