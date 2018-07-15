package edu.gdut.myBoot.service;

import edu.gdut.myBoot.polo.User;

import java.util.List;

/**
 * Created by Jun on 2018/7/12.
 */
public interface UserService {
    String getAllUser();

    String findUserById(long id);

    String addUser(User user);

    String updateUserById(long id, User user);

    String deleteUserById(long id);
}
