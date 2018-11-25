package lana.application.repository;

import lana.application.model.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepo extends CrudRepository<Group, Integer> {
    @Override
    List<Group> findAll();
}
