package lana.application.service;

import lana.application.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findAllFull();

    User findById(int id);

    User findFullById(int id);

    void save(User user);

    boolean delete(int id);
}
