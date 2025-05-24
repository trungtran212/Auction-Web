package com.example.InternProject.service.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    public Boolean createUsers(Users user) throws Exception {
        try {
            UserEntity userEntity = new UserEntity();
            user.setCreateAt(LocalDateTime.now());
            user.setUpdateAt(LocalDateTime.now());

            BeanUtils.copyProperties(user, userEntity);
            userRepository.save(userEntity);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Users> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(user -> new Users(
                user.getUserID(),
                user.getUsername(),
                user.getPassword(),
                user.getAddress(),
                user.getBalance(),
                user.getGender(),
                user.getCreateAt(),
                user.getUpdateAt())).collect(Collectors.toList());
    }

    public Boolean deleteUser(Long ID) throws Exception {
        try {
            UserEntity userEntity = userRepository.findById(ID).isPresent() ? userRepository.findById(ID).get() : null;
            assert userEntity != null;
            userRepository.delete(userEntity);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Users getUserByID(Long ID) throws Exception {
        try {
            UserEntity userEntity = userRepository.findById(ID).isPresent() ? userRepository.findById(ID).get() : null;
            Users users = new Users();
            assert userEntity != null;
            BeanUtils.copyProperties(userEntity, users);
            return users;
        } catch (NoSuchElementException e) {
            throw new Exception(e.getMessage());
        }
    }

    public Boolean updateBalance(Long ID, Double amountToAdd) throws Exception {
        try {
            UserEntity userEntity = userRepository.findById(ID)
                    .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + ID));
            Double currentBalance = userEntity.getBalance();
            userEntity.setBalance(currentBalance + amountToAdd);
            userRepository.save(userEntity);

            return true;
        } catch (NoSuchElementException e) {
            throw new Exception(e.getMessage());
        }
    }

}
