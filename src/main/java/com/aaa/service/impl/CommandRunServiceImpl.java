package com.aaa.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.CommandItemDao;
import com.aaa.entity.CommandItem;
import com.aaa.service.CommandRunService;
import com.aaa.util.CRKeyPress;

@Service
public class CommandRunServiceImpl implements CommandRunService {
	private static Logger log = LogManager.getLogger(CommandRunServiceImpl.class);
	@Autowired
	private CommandItemDao commandItemDao;

	@Override
	public String runCommand(String group_id) {
		// TODO Auto-generated method stub
		KeyPressRun keyPressRun = new KeyPressRun(commandItemDao, group_id);
		Thread t = new Thread(keyPressRun);
		t.start();
		return "请在五秒钟内切换到输入焦点位置";
	}

	@Override
	public String runCommandChecked(String[] ids) {
		// TODO Auto-generated method stub
		UUID[] uuid_ids = new UUID[ids.length];
		for (int i = 0; i < ids.length; i++) {
			uuid_ids[i] = UUID.fromString(ids[i]);
		}
		KeyPressRunChecked keyPressRunChecked = new KeyPressRunChecked(commandItemDao, uuid_ids);
		Thread t = new Thread(keyPressRunChecked);
		t.start();
		return "请在五秒钟内切换到输入焦点位置";
	}

	private class KeyPressRun implements Runnable {
		private CommandItemDao commandItemDao;
		private String group_id;

		public KeyPressRun(CommandItemDao commandItemDao, String group_id) {
			super();
			this.commandItemDao = commandItemDao;
			this.group_id = group_id;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(5000);
				List<CommandItem> commandItem = commandItemDao.getCommandItemByGroupID(UUID.fromString(group_id));
				for (CommandItem ci : commandItem) {
					if (!CRKeyPress.processKey(ci.getCommand())) {
						break;
					}
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				log.error("", e);
			}
		}
	}

	private class KeyPressRunChecked implements Runnable {
		private CommandItemDao commandItemDao;
		private UUID[] ids;

		public KeyPressRunChecked(CommandItemDao commandItemDao, UUID[] ids) {
			super();
			this.commandItemDao = commandItemDao;
			this.ids = ids;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(5000);
				List<CommandItem> commandItem = commandItemDao.getCommandItemByIds(ids);
				for (CommandItem ci : commandItem) {
					if (!CRKeyPress.processKey(ci.getCommand())) {
						break;
					}
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				log.error("", e);
			}
		}
	}

}
