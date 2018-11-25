package lana.application.service;

import lana.application.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    Group findById(int id);

    void save(Group group);

    boolean delete(int id);
}
