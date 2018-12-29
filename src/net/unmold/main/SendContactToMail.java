package net.unmold.main;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//contact formの内容をメールで自分に送る

public class SendContactToMail {

	public void sendContactToMail(String name, String mail, String text) {
		String from = "kaneko.naoki.0620@gmail.com";

		final String username = "kaneko.naoki.0620@gmail.com";
		final String password = "naotestnao3";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lpeopleocomevtogethere@gmail.com"));
			message.setSubject("Got a message from contact form!");
			message.setText("Name:"+name+"<br>Mail Address:"+mail+"<br>Text:"+text);
			Transport.send(message);
			System.out.println("Sent email successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
