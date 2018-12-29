package net.unmold.beans;

import java.io.Serializable;

public class Contact implements Serializable{

	private String name;
	private String mail;
	private String text;

	public Contact(String name, String mail, String text) {
		this.name = name;
		this.mail = mail;
		this.text = text;
	}


	public String getName() {return name;}
	public String getMail() {return mail;}
	public String getText() {return text;}

}
