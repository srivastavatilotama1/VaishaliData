package training.spring.hibernateTemplate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "usertable")
public class User implements Serializable {
       
        private static final long serialVersionUID = 8496087166198616020L;
        private int userId;
        private String userName;
        private Integer age;
        private Boolean registered;
       
        @Id
        @GeneratedValue
        @Column(name = "userId")
        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }
        @Column(name = "userName", nullable=false)
        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }
        @Column(name = "age")
        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }
        @Column(name = "registered", nullable=false)
        public Boolean getRegistered() {
                return registered;
        }

        public void setRegistered(Boolean registered) {
                this.registered = registered;
        }

}

