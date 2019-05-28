package com.sisinfo.Hospital.service;


import com.sisinfo.Hospital.model.User;

import java.util.List;

public interface UserService {

    Iterable<User> listAllUsers();
    User findUser(Integer id);
    void saveUser(User user);
    void deleteUser(Integer id);
}
