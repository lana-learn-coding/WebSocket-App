package lana.application.repository;

import lana.application.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();
}
