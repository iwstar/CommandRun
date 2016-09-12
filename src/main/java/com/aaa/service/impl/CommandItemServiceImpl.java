package com.aaa.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.CommandItemDao;
import com.aaa.entity.CommandItem;
import com.aaa.service.CommandItemService;

@Service
public class CommandItemServiceImpl implements CommandItemService {
	@Autowired
	private CommandItemDao commandItemDao;

	@Override
	public String addCommandItem(CommandItem commandItem) {
		// TODO Auto-generated method stub
		String id = "";
		commandItem.setCreate_date(new Date());
		commandItem.setStatus(1);
		id = commandItemDao.addCommandItem(commandItem);
		return id;
	}

	@Override
	public CommandItem getCommandItemById(String item_id) {
		// TODO Auto-generated method stub

		return commandItemDao.getCommandItemById(UUID.fromString(item_id));
	}

	@Override
	public String updateCommandItem(CommandItem commandItem) {
		// TODO Auto-generated method stub
		String message = "";
		CommandItem ci = commandItemDao.getCommandItemById(commandItem.getId());
		if (ci != null) {
			ci.setName(commandItem.getName());
			ci.setRun_index(commandItem.getRun_index());
			ci.setCommand(commandItem.getCommand());
			ci.setRemark(commandItem.getRemark());
			ci.setStatus(commandItem.getStatus());
			commandItemDao.updateCommandItem(ci);
			message = "success";
		}
		return message;
	}

	@Override
	public List<CommandItem> getCommandItemListByGroupId(String group_id) {
		// TODO Auto-generated method stub
		return commandItemDao.getCommandItemByGroupID(UUID.fromString(group_id));
	}
	
	@Override
	public String delCommandItemById(String item_id) {
		// TODO Auto-generated method stub
		commandItemDao.delCommandItem(UUID.fromString(item_id));
		return "";
	}

}
