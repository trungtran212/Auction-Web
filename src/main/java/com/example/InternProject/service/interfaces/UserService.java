package com.example.InternProject.service.interfaces;

import java.util.List;

import com.example.InternProject.entity.UserEntity;
import com.example.InternProject.model.Users;

public interface UserService {
  Users createUser(Users user) throws Exception;

  List<UserEntity> getAllUsers();

  Boolean deleteUserByID(Long ID) throws Exception;

  Users updateUser(Long ID, Users user) throws Exception;

  UserEntity getUserByID(Long ID) throws Exception;

  List<UserEntity> getUserByName(String name) throws Exception;
}
