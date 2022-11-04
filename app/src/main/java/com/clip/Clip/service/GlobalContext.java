package com.clip.Clip.service;

import com.clip.Clip.domain.Group;

import java.util.ArrayList;
import java.util.List;

public class GlobalContext {
    List<Group> groups = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
    private static final GlobalContext holder = new GlobalContext();

    public static GlobalContext getInstance() {return holder;}

}
