package com.aaa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaa.entity.CommandItem;
import com.aaa.service.CommandItemService;
import com.aaa.service.CommandRunService;

@Controller
@RequestMapping(value = "item")
public class CommandItemController {
	@Autowired
	private CommandItemService commandItemService;

	@Autowired
	private CommandRunService commandRunService;

	@RequestMapping(value = "createItem/{dest}/{group_id}/")
	public String createItem(@PathVariable String dest, @PathVariable String group_id, Model model) {
		model.addAttribute("group_id", group_id);
		return dest;
	}

	@RequestMapping(value = "itemSave/{dest}/{group_id}/", method = RequestMethod.POST)
	public String itemSave(@PathVariable String dest,@PathVariable String group_id, CommandItem commandItem, Model model) {
		commandItemService.addCommandItem(commandItem);
		return "forward:/item/itemList/" + dest + "/" + commandItem.getGroup_id().toString() + "/";
	}

	@RequestMapping(value = "itemList/{dest}/{group_id}/")
	public String itemList(@PathVariable String dest, @PathVariable String group_id, Model model) {
		model.addAttribute("group_id", group_id);
		model.addAttribute("commandItemList", commandItemService.getCommandItemListByGroupId(group_id));
		return dest;
	}

	@RequestMapping(value = "commandRun/{dest}/{group_id}/")
	public String commandRun(@PathVariable String dest, @PathVariable String group_id, Model model) {
		String message = "";
		message = commandRunService.runCommand(group_id);
		model.addAttribute("message", message);
		return dest;
	}
	
	@RequestMapping(value="commandRunCheckey/{dest}/",method=RequestMethod.POST)
	public String commandRunChecked(@PathVariable String dest,@RequestParam String[] command_list,Model model){
		model.addAttribute("message", commandRunService.runCommandChecked(command_list));
		return dest;
	}

	@RequestMapping(value = "commandItemModify/{dest}/{item_id}/")
	public String commandItemModify(@PathVariable String dest, @PathVariable String item_id, Model model) {
		model.addAttribute("commandItem", commandItemService.getCommandItemById(item_id));
		return dest;
	}

	@RequestMapping(value = "commandItemModifySave/{dest}/{item_id}/{group_id}/", method = RequestMethod.POST)
	public String commandItemModifySave(@PathVariable String dest, @PathVariable String item_id, @PathVariable String group_id, CommandItem commandItem, Model model) {
		commandItem.setId(UUID.fromString(item_id));
		commandItemService.updateCommandItem(commandItem);
		return "forward:/item/itemList/" + dest + "/" + group_id + "/";
	}

	@RequestMapping(value = "commandItemDel/{dest}/{item_id}/{group_id}/")
	public String commandItemDel(@PathVariable String dest, @PathVariable String item_id, @PathVariable String group_id, Model model) {
		commandItemService.delCommandItemById(item_id);
		return "forward:/item/itemList/" + dest + "/" + group_id + "/";
	}

}
