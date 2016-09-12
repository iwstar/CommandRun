package com.aaa.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.CommandGroupDao;
import com.aaa.dao.CommandItemDao;
import com.aaa.entity.CommandGroup;
import com.aaa.entity.CommandItem;
import com.aaa.service.CommandGroupService;

@Service
public class CommandGroupServiceImpl implements CommandGroupService {
	@Autowired
	private CommandGroupDao commandGroupDao;
	@Autowired
	private CommandItemDao commandItemDao;

	@Override
	public String addCommandGroup(String name) {
		// TODO Auto-generated method stub
		String id = "";
		CommandGroup commandGroup = new CommandGroup();
		commandGroup.setName(name);
		commandGroup.setCreate_date(new Date());
		commandGroup.setStatus(1);
		id = commandGroupDao.addCommandGroup(commandGroup);
		return id;
	}

	@Override
	public CommandGroup getCommandGroup(String group_id) {
		// TODO Auto-generated method stub

		return commandGroupDao.getCommandGroupById(UUID.fromString(group_id));
	}

	@Override
	public String updateCommandGroup(CommandGroup commandGroup) {
		// TODO Auto-generated method stub
		String message = "";
		CommandGroup cg = commandGroupDao.getCommandGroupById(commandGroup.getId());
		if (cg != null) {
			cg.setName(commandGroup.getName());
			cg.setStatus(commandGroup.getStatus());
			commandGroupDao.updateCommandGroup(cg);
			message = "success";
		}
		return message;
	}

	@Override
	public List<CommandGroup> getCommandGroupList() {
		// TODO Auto-generated method stub
		return commandGroupDao.getCommandGroupAll();
	}

	@Override
	public String delCommandGroupById(String group_id) {
		// TODO Auto-generated method stub
		List<CommandItem> commandItemList=commandItemDao.getCommandItemByGroupID(UUID.fromString(group_id));
		for(CommandItem ci:commandItemList){
			commandItemDao.delCommandItem(ci.getId());
		}
		commandGroupDao.delCommandGroupById(UUID.fromString(group_id));
		return "";
	}
}
