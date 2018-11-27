package lana.application.controller.chatController;

import lana.application.model.Message;
import lana.application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatSocketController {
    private MessageService messageService;

    @Autowired
    public ChatSocketController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/{groupId}")
    @SendTo("/group/{groupId}")
    public Message handleSentMessage(@DestinationVariable("groupId") int groupId,
                                     @Payload Message message) {
        messageService.save(message);
        return messageService.findById(message.getId());
    }

}
