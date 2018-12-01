package lana.application.support.dataBinding.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lana.application.model.Message;
import lana.application.service.GroupService;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageDeserializer extends StdDeserializer<Message> {

    private GroupService groupService;
    private UserService userService;

    @Autowired
    public void setGroupServiceAndUserService(GroupService groupService,
                                              UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    public MessageDeserializer() {
        this(null);
    }

    public MessageDeserializer(Class<?> t) {
        super(t);
    }

    @Override
    public Message deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        int groupId = Integer.parseInt(node.get("group").asText());
        int userId = Integer.parseInt(node.get("user").asText());
        String content = node.get("content").asText();
        Message message = new Message();
        message.setContent(content);
        message.setGroup(groupService.findById(groupId));
        message.setUser(userService.findById(userId));
        return message;
    }
}
