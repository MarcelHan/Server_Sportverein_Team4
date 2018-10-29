package persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistence.HibernateUtil;


public class BaseDAO<T, PK extends Serializable> {

	private SessionFactory _sessionFactory = HibernateUtil.getSessionFactory();
	private Class<T> _type;

	public BaseDAO(Class<T> type) {
		_type = type;
	}

	public List<T> getAll(){
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(_type);
		query.from(_type);

		List<T> result = session.createQuery(query).getResultList();
		tx.commit();
		session.close();
		return result;
	}

	public void insert(T t) {
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);
		tx.commit();
		session.close();
	}

	public void delete(T t) {
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(t);
		session.delete(t);
		tx.commit();
		session.close();
	}

	public T getByKey(PK key) {
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		T t = session.get(_type, key);
		t.toString();
		tx.commit();
		session.close();
		return t;
	}





}
