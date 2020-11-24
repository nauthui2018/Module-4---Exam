package com.nauthui7.demo.service.Implement;

import com.nauthui7.demo.model.Group;
import com.nauthui7.demo.repository.GroupRepository;
import com.nauthui7.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements BaseService<Group> {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group findById(int id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Group remove(int id) {
        Group group = findById(id);
        groupRepository.delete(group);
        return group;
    }
}
