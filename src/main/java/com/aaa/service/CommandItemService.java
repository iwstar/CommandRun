package com.aaa.service;

import java.util.List;

import com.aaa.entity.CommandItem;

public interface CommandItemService {
	public String addCommandItem(CommandItem commandItem);

	public CommandItem getCommandItemById(String item_id);

	public String updateCommandItem(CommandItem commandItem);

	public List<CommandItem> getCommandItemListByGroupId(String group_id);

	public String delCommandItemById(String item_id);
}
