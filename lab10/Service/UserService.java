package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getall() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean updateUser(Integer ID, User user) {
        if (userRepository.existsById(ID)) {//Note: Verify that the user exists.
            User retriveUser = userRepository.getById(ID);
            retriveUser.setAge(user.getAge());
            retriveUser.setRole(user.getRole());
            retriveUser.setName(user.getName());
            retriveUser.setEmail(user.getEmail());
            retriveUser.setPassword(user.getPassword());
            return true;
        }
        return false;
    }

    public Boolean deleteUser(Integer ID) {
        if (userRepository.existsById(ID)) {//Note: Verify that the user exists.
            userRepository.delete(userRepository.getById(ID));
            return true;}
        return false;}

}
