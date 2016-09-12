package com.aaa.dao;

import java.util.List;
import java.util.UUID;

import com.aaa.entity.CommandItem;

public interface CommandItemDao {
public String addCommandItem(CommandItem commandItem);
public CommandItem getCommandItemById(UUID item_id);
public String updateCommandItem(CommandItem commandItem);
public List<CommandItem> getCommandItemByGroupID(UUID group_id);
public String delCommandItem(UUID item_id);
}
