package com.aaa.service;

import java.util.List;

import com.aaa.entity.CommandGroup;

public interface CommandGroupService {
public String addCommandGroup(String name);
public CommandGroup getCommandGroup(String group_id);
public String updateCommandGroup(CommandGroup commandGroup);
public List<CommandGroup> getCommandGroupList();
public String delCommandGroupById(String group_id);
}
