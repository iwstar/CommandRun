package com.aaa.controller;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaa.entity.CommandGroup;
import com.aaa.service.CommandGroupService;

@Controller
@RequestMapping("group")
public class CommandGroupController {
	private static Logger logger=LogManager.getLogger(CommandGroupController.class);
	@Autowired
	private CommandGroupService commandGroupService;

	@RequestMapping(value = "openPage/{dest}/")
	public String openPage(@PathVariable String dest) {
		return dest;
	}

	@PostMapping(value = "addCommandGroup/{dest}/")
	public String addCommandGroup(@PathVariable String dest, @RequestParam String name, Model model) {
		commandGroupService.addCommandGroup(name);
		logger.info("group name:"+name);
		return "forward:/group/commandGroupList/" + dest + "/";
	}

	@RequestMapping(value = "commandGroupList/{dest}/")
	public String commandGroupList(@PathVariable String dest, Model model) {
		model.addAttribute("commandGroupList", commandGroupService.getCommandGroupList());
		return dest;
	}

	@RequestMapping(value = "commandGroupModify/{dest}/{group_id}/")
	public String commandGroupModify(@PathVariable String dest, @PathVariable String group_id, Model model) {
		model.addAttribute("commandGroup", commandGroupService.getCommandGroup(group_id));
		return dest;
	}

	@RequestMapping(value = "commandGroupModifySave/{dest}/{group_id}/", method = RequestMethod.POST)
	public String commandGroupModifySave(@PathVariable String dest, @PathVariable String group_id, CommandGroup commandGroup, Model model) {
		commandGroup.setId(UUID.fromString(group_id));
		commandGroupService.updateCommandGroup(commandGroup);
		return "forward:/group/commandGroupList/" + dest + "/";
	}

	@RequestMapping(value = "commandGroupDelete/{dest}/{group_id}/")
	public String commandGroupDelete(@PathVariable String dest, @PathVariable String group_id) {
		commandGroupService.delCommandGroupById(group_id);
		return "forward:/group/commandGroupList/" + dest + "/";
	}
}
