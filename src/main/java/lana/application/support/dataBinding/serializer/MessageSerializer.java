package lana.application.support.dataBinding.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lana.application.model.Message;
import lana.application.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;

//Not Used
@Component
public class MessageSerializer extends StdSerializer<Message> {

    public MessageSerializer() {
        this(null);
    }

    public MessageSerializer(Class<Message> t) {
        super(t);
    }

    @Override
    public void serialize(Message value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStringField("id", String.valueOf(value.getId()));
        gen.writeStringField("content", value.getContent());
        gen.writeObjectField("group", value.getGroup());
        User user = value.getUser();
        user.setPassword("");
        gen.writeObjectField("user", user);
    }
}
