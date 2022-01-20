package com.example.zbl.service;

import com.example.zbl.DTO.UserDTO;
import com.example.zbl.entity.UserEntity;
import com.example.zbl.exeption.UserAlreadyExists;
import com.example.zbl.exeption.UserDontExist;
import com.example.zbl.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExists {
        if(userRepo.findByName(user.getName())!=null){
            throw new UserAlreadyExists("Пользователь уже существует");
        }
        return userRepo.save(user);
    }

    public UserDTO getUser(int id) throws UserDontExist {
        UserEntity user = userRepo.findById(id).get() ;
        if (user == null) {
            throw new UserDontExist("Пользователь по данному ID не существует");
        }
        return UserDTO.getUserDTO(user);
    }






}
