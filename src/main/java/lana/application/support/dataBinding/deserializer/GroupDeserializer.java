package lana.application.support.dataBinding.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lana.application.model.Group;
import lana.application.service.MessageService;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GroupDeserializer extends StdDeserializer<Group> {

    private MessageService messageService;
    private UserService userService;

    @Autowired
    public void setMessageServiceAndUserService(MessageService messageService,
                                                UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    public GroupDeserializer() {
        this(null);
    }

    public GroupDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Group deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        return null;
    }
}
