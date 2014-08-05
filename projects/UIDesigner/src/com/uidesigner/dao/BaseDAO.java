package com.uidesigner.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Shrek.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月3日 下午11:13:18
 */
public class BaseDAO {

	private static final String RESOURCE = "com/hibernate/config/hibernate.cfg.xml";

	private static BaseDAO instance = new BaseDAO();

	private Configuration configuration = new Configuration();

	private SessionFactory sessionFactory = null;

	// ThreadLocal.
	private Session session = null;

	private BaseDAO() {
		this.initConfiguration();
		this.initSessionFactory();
		this.initSession();
	};

	public static BaseDAO getInstance() {
		return BaseDAO.instance;
	};

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void save(Object obj) {
		this.save(Arrays.asList(obj));
	}

	public void save(List<?> objList) {
		this.batchExecute(ActionType.SAVE, objList);
	}

	public void update(Object obj) {
		this.update(Arrays.asList(obj));
	}

	public void update(List<?> objList) {
		this.batchExecute(ActionType.UPDATE, objList);
	}

	public void delete(Object obj) {
		this.delete(Arrays.asList(obj));
	}

	public void delete(List<Object> objList) {
		this.batchExecute(ActionType.DELETE, objList);
	}

	@SuppressWarnings("unchecked")
	public <T> T loadById(Class<T> entityClass, Serializable id) {
		return (T) this.getSession().byId(entityClass).load(id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> loadAll(Class<T> entityClass) {
		Query qry = this.getSession().createQuery("from " + entityClass.getName());
		return qry.list();
	}

	public Session getSession() {
		return this.session;
	}

	private void batchExecute(ActionType actionType, List<?> objList) {
		if ((objList == null) || objList.isEmpty()) {
			return;
		}
		Session session = this.getSession();
		session.beginTransaction();
		for (int i = 0; i < objList.size(); i++) {
			this.actionPerform(session, actionType, objList.get(i));
			if ((i % 20) == 0) {
				session.flush();
				session.clear();
			}
		}
		session.getTransaction().commit();
	}

	private void actionPerform(Session session, ActionType actionType, Object obj) {
		if (ActionType.SAVE.equals(actionType)) {
			session.save(obj);
		} else if (ActionType.UPDATE.equals(actionType)) {
			session.update(obj);
		} else if (ActionType.DELETE.equals(actionType)) {
			session.delete(obj);
		} else {
		}
	}

	private void initConfiguration() {
		this.getConfiguration().configure(BaseDAO.RESOURCE);
	}

	private void initSessionFactory() {
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		StandardServiceRegistryBuilder ssrb = builder.configure(BaseDAO.RESOURCE);
		this.sessionFactory = this.getConfiguration().buildSessionFactory(ssrb.build());
	}

	private void initSession() {
		this.session = this.getSessionFactory().openSession();
	}

	private Configuration getConfiguration() {
		return this.configuration;
	}

}