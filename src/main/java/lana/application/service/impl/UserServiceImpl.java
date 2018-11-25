package lana.application.service.impl;

import lana.application.model.User;
import lana.application.repository.UserRepo;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public void setUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepo.findAll();
        for (User user : users) {
            user.passwordRemoval();
        }
        return users;
    }

    @Override
    public List<User> findAllFull() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.passwordRemoval();
        }
        return user;
    }

    @Override
    public User findFullById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public boolean delete(int id) {
        if (findFullById(id) != null) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
