package lana.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lana.application.support.dataBinding.deserializer.MessageDeserializer;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@JsonIgnoreProperties(value = {"group","user"})
@JsonDeserialize(using = MessageDeserializer.class)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    private String content;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
