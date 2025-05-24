package com.example.InternProject.service.interfaces;

import java.util.List;

import com.example.InternProject.model.Users;

public interface UserService {
    Boolean createUsers(Users user) throws Exception;

    List<Users> getAllUsers();

    Boolean deleteUser(Long ID) throws Exception;

    Users getUserByID(Long ID) throws Exception;

    Boolean updateBalance(Long ID, Double balance) throws Exception;
}
