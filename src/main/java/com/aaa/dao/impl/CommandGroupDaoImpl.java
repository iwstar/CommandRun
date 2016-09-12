package com.aaa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.aaa.dao.CommandGroupDao;
import com.aaa.entity.CommandGroup;

@Component
public class CommandGroupDaoImpl extends HibernateDaoSupport implements CommandGroupDao {

	@Autowired
	private void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public String addCommandGroup(CommandGroup commandGroup) {
		// TODO Auto-generated method stub
		Serializable s = this.getHibernateTemplate().save(commandGroup);
		return s.toString();
	}

	@Override
	public CommandGroup getCommandGroupById(UUID id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CommandGroup.class, id);
	}

	@Override
	public String updateCommandGroup(CommandGroup commandGroup) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(commandGroup);
		return null;
	}

	@Override
	public List<CommandGroup> getCommandGroupAll() {
		// TODO Auto-generated method stub
		List<CommandGroup> commandGroupList = new ArrayList<CommandGroup>();
		commandGroupList = this.getHibernateTemplate().loadAll(CommandGroup.class);
		return commandGroupList;
	}

	@Override
	public String delCommandGroupById(UUID id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(this.getCommandGroupById(id));
		return null;
	}

}
