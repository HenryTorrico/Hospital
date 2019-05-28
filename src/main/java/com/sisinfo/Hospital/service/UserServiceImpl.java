package com.sisinfo.Hospital.service;

import com.sisinfo.Hospital.model.User;
import com.sisinfo.Hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;

    @Autowired
    @Qualifier(value = "userRepository")
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(Integer id) {
        Optional<User> opt;
        opt = userRepository.findById(id);
        return opt.get();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
