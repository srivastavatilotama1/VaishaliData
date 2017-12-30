package training.spring.hibernateTemplate;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.spring.hibernateTemplate.Dao.UserDaoImpl;
import training.spring.hibernateTemplate.entity.User;

public class UserClientApp {
	
	static UserDaoImpl userDao;
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"user-config.xml");
		userDao = (UserDaoImpl) appContext.getBean("userDao");

		/* insert */
		System.out.println("----------- Saving User object -------------");
		saveUser();

		/* retrieve all */
		System.out.println("----------- Retrieving all users -------------");
		retrieveAllUsers();

		/* retrieve */
		System.out
				.println("----------- Retrieving user with id 1 -------------");
		retrieveUser(1);

		/* update */
		System.out
				.println("----------- Modifying user with id 1 -------------");
		updateUser(1);

		/* delete */
		System.out.println("----------- deleting user with id 2 -------------");
		deleteUser(2);
		
		System.out.println("----------- Retrieving all users -------------");
		retrieveAllUsers();
	}

	public static void saveUser() {
		User user1 = new User();
		user1.setAge(23);
		user1.setUserName("Aditya");
		user1.setRegistered(true);
		userDao.saveUser(user1);
		User user2 = new User();
		user2.setAge(18);
		user2.setUserName("Soha");
		user2.setRegistered(false);
		userDao.saveUser(user2);
	}

	public static void retrieveAllUsers() {
		List<User> userList = userDao.getAllUser(new User());
		Iterator<User> it = userList.iterator();
		while (it.hasNext()) {
			User user = (User) it.next();
			System.out.println("UserID : " + user.getUserId()+ "   User Name : " + user.getUserName()
					+ "  User Age : " + user.getAge());
		}
	}

	public static void retrieveUser(int userid) {
		User user = userDao.selectUserById(userid);
		System.out.println("User Name : " + user.getUserName()
				+ "  User Age : " + user.getAge());

	}

	public static void updateUser(int userid) {
		User user = userDao.selectUserById(userid);
		user.setUserName("Kumar");
		userDao.saveUser(user);
		User userChanged = userDao.selectUserById(userid);
		System.out.println("User Name : " + userChanged.getUserName()
				+ "  User Age : " + userChanged.getUserName());
	}

	
	 public static void deleteUser(int userid) {
		 User userToDelete = userDao.selectUserById(userid);
		 userDao.deleteUser(userToDelete); 	  
	  }
	 
}
