package com.igate.lab3_2.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
		@NotEmpty(message="username can not be blank")
		@Pattern(regexp="[a-zA-Z]{4,10}",message="Please enter only letters")
		private String username;
		@NotEmpty(message="please enter a password")
		private String password;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

}
