package com.nauthui7.demo.controller.api;

import com.nauthui7.demo.model.Group;
import com.nauthui7.demo.service.Implement.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIGroup {
    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ResponseEntity<List<Group>> findAll() {
        List<Group> allGroups = groupService.findAll();
        if (allGroups == null) {
            return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Group>>(allGroups, HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Group> delete(@PathVariable("id") int id) {
        Group group = groupService.remove(id);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public ResponseEntity<Group> create(@RequestBody Group group) {
        Group newGroup = groupService.save(group);
        return new ResponseEntity<Group>(newGroup, HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public ResponseEntity<Group> getOne(@PathVariable("id") int id) {
        Group group = groupService.findById(id);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @RequestMapping(value = "/group", method = RequestMethod.PUT)
    public ResponseEntity<Group> update(@RequestBody Group group) {
        groupService.save(group);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }
}
