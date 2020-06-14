package com.tl666.pojo;

public class LoginTemplate {
		private String username;
		private String pwd;
		private String identity;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getIdentity() {
			return identity;
		}
		public void setIdentity(String identity) {
			this.identity = identity;
		}
		@Override
		public String toString() {
			return "LoginTemplate [username=" + username + ", pwd=" + pwd + ", identity=" + identity + "]";
		}
		
}
