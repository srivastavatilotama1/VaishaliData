package training.spring.hibernateTemplate.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import org.springframework.stereotype.Repository;


import training.spring.hibernateTemplate.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void saveUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
	}

	public void deleteUser(User user) {
		hibernateTemplate.delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser(User user) {
		return (List<User>) hibernateTemplate.find("from "
				+ User.class.getName());
	}

	public User selectUserById(int userId) {
		return hibernateTemplate.get(User.class, userId);
	}

}
