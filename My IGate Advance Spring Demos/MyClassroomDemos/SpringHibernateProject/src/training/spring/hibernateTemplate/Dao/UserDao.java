package training.spring.hibernateTemplate.Dao;

import java.util.List;

import training.spring.hibernateTemplate.entity.User;



public interface UserDao {
        public void saveUser(User user);
        public List<User> getAllUser(User user);
        public User selectUserById(int userId);
        public void deleteUser(User user);
}

