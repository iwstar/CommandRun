package com.aaa.dao;

import java.util.List;
import java.util.UUID;

import com.aaa.entity.CommandGroup;

public interface CommandGroupDao {
	public String addCommandGroup(CommandGroup commandGroup);

	public CommandGroup getCommandGroupById(UUID id);

	public String updateCommandGroup(CommandGroup commandGroup);

	public List<CommandGroup> getCommandGroupAll();

	public String delCommandGroupById(UUID id);
}
