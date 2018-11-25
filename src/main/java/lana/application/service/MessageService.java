package lana.application.service;

import lana.application.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();

    List<Message> findByUser(int userId);

    List<Message> findByGroup(int groupId);

    Message findById(int id);

    void save(Message message);

    boolean delete(int id);
}
