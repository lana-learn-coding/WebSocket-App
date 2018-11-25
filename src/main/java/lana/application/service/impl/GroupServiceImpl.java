package lana.application.service.impl;

import lana.application.model.Group;
import lana.application.repository.GroupRepo;
import lana.application.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

    private GroupRepo groupRepo;

    @Autowired
    public void setGroupRepo(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public Group findById(int id) {
        return groupRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Group group) {
        groupRepo.save(group);
    }

    @Override
    public boolean delete(int id) {
        if (findById(id) != null) {
            groupRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
