package lana.application.service.impl;

import lana.application.model.Message;
import lana.application.repository.MessageRepo;
import lana.application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    private MessageRepo messageRepo;

    @Autowired
    public void setMessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    @Override
    public List<Message> findByGroup(int groupId) {
        return messageRepo.findAllByGroupId(groupId);
    }

    @Override
    public Message findById(int id) {
        return messageRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Message message) {
        messageRepo.save(message);
    }

    @Override
    public boolean delete(int id) {
        if (findById(id) != null) {
            messageRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
