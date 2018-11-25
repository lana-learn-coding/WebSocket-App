package lana.application.repository;

import lana.application.model.Group;
import lana.application.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    @Override
    List<Message> findAll();

    List<Message> findAllByGroupId(int id);

    List<Message> findAllByUserId(int id);
}
