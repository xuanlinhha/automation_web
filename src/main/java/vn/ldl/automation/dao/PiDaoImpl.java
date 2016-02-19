package vn.ldl.automation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.ldl.automation.entity.Pi;

/**
 * @author xuanlinhha
 * 
 */
@Repository
public class PiDaoImpl implements PiDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveOrUpdate(Pi pi) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pi);
	}

	@Override
	@Transactional
	public Pi getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Pi pi = (Pi) session.get(Pi.class, id);
		return pi;
	}

	@Override
	@Transactional
	public Pi getByOwner(String username) {

		String hql = "from Pi where owner.username = :username and enabled = true";
		Session session = sessionFactory.getCurrentSession();
		return (Pi) session.createQuery(hql).setParameter("username", username)
				.uniqueResult();
	}

	@Override
	@Transactional
	public List<Pi> getAllInfos() {
		@SuppressWarnings("unchecked")
		List<Pi> pis = sessionFactory.getCurrentSession()
				.createQuery("from Pi where enabled = true").list();
		return pis;
	}

}
