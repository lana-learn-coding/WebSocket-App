package lana.application.controller;

import lana.application.model.Group;
import lana.application.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "/groups/")
    public ResponseEntity<List<Group>> getAllGroup() {
        List<Group> allGroup = groupService.findAll();
        if (allGroup.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allGroup, HttpStatus.OK);
    }

    @GetMapping(path = "/groups/{id}")
    public ResponseEntity<Group> getOneGroup(@PathVariable("id") int id) {
        Group foundedGroup = groupService.findById(id);
        if (foundedGroup != null) {
            return new ResponseEntity<>(foundedGroup, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/groups/")
    public ResponseEntity<Void> createGroup(@RequestBody Group group, UriComponentsBuilder uriComponentsBuilder) {
        groupService.save(group);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/groups/{id}").buildAndExpand(group.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "/groups/{id}")
    public ResponseEntity<Void> updateGroup(@PathVariable("id") int id,
                                            @RequestBody Group group) {
        if (groupService.findById(id) != null) {
            group.setId(id);
            groupService.save(group);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/groups/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("id") int id) {
        if (groupService.findById(id) != null) {
            groupService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(path = "/groups/{id}")
    public ResponseEntity<Void> patchGroup(@PathVariable("id") int id,
                                           @RequestBody Group groupPatch) {
        Group group = groupService.findById(id);
        if (group != null) {
            if (groupPatch.getName() != null) group.setName(groupPatch.getName());
            if (groupPatch.getMessages() != null) group.setMessages(groupPatch.getMessages());
            if (groupPatch.getUsers() != null) group.setUsers(groupPatch.getUsers());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
