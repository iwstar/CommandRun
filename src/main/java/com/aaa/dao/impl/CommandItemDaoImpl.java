package com.aaa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.aaa.dao.CommandItemDao;
import com.aaa.entity.CommandItem;

@Component
public class CommandItemDaoImpl extends HibernateDaoSupport implements CommandItemDao {
	private static Logger log = LogManager.getLogger(CommandItemDaoImpl.class);

	@Autowired
	private void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public String addCommandItem(CommandItem commandItem) {
		// TODO Auto-generated method stub
		Serializable s = this.getHibernateTemplate().save(commandItem);
		return s.toString();
	}

	@Override
	public CommandItem getCommandItemById(UUID item_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CommandItem.class, item_id);
	}

	@Override
	public String updateCommandItem(CommandItem commandItem) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(commandItem);
		return null;
	}

	@Override
	public List<CommandItem> getCommandItemByGroupID(UUID group_id) {
		// TODO Auto-generated method stub
		List<CommandItem> commandItemList = new ArrayList<CommandItem>();
		String hql = "from com.aaa.entity.CommandItem where group_id=:group_id order by run_index";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		try {
			Query<CommandItem> query = session.createQuery(hql, CommandItem.class);
			query.setParameter("group_id", group_id);
			commandItemList = query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("", e);
		} finally {
			session.close();
		}
		return commandItemList;
	}

	@Override
	public String delCommandItem(UUID item_id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(this.getCommandItemById(item_id));
		return null;
	}
	
	@Override
	public List<CommandItem> getCommandItemByIds(UUID[] ids) {
		// TODO Auto-generated method stub
		List<CommandItem> commandItemList = new ArrayList<CommandItem>();
		String hql = "from com.aaa.entity.CommandItem where id in (:ids) order by run_index";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		try {
			Query<CommandItem> query = session.createQuery(hql, CommandItem.class);
			query.setParameterList("ids", ids);
			commandItemList = query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("", e);
		} finally {
			session.close();
		}
		return commandItemList;
	}
}
