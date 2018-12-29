package net.unmold.beans;

import java.io.Serializable;

public class User implements Serializable {

	private int id;
	private String name;
	private String mail;
	private String password;

	public User() {
	};

	public User(String name, String mail, String password) {
		this.name = name;
		this.mail = mail;
		this.password = password;
	}

	public User(int id, String name, String mail, String password) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

}
