package lana.application.configuration.formatter;

import lana.application.model.Group;
import lana.application.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class GroupFormatter implements Formatter<Group> {
    private GroupService groupService;

    @Autowired
    public GroupFormatter(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Group parse(String text, Locale locale) throws ParseException {
        try {
            int id = Integer.parseInt(text);
            return groupService.findById(id);
        } catch (Throwable e) {
            return null;
        }
    }

    @Override
    public String print(Group object, Locale locale) {
        return object.getId() + "-" + object.getName();
    }
}
