package com.example.InternProject.service.implement;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.InternProject.entity.UserEntity;
import com.example.InternProject.model.Users;
import com.example.InternProject.repository.UserRepository;
import com.example.InternProject.service.interfaces.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Users createUsers(Users user) throws Exception {
        try {
            UserEntity userEntity = new UserEntity();
            user.setCreateAt(LocalDateTime.now());
            user.setUpdateAt(LocalDateTime.now());

            BeanUtils.copyProperties(user, userEntity);
            userRepository.save(userEntity);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
