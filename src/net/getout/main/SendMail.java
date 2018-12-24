package net.getout.main;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//上：会員登録用　下：パス再発行用

public class SendMail {

	public void SendMailExecute(String mail, String token) {

		String from = "kaneko.naoki.0620@gmail.com"; //Sender's email
		String crlf = System.getProperty("line.separator");

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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject("[UnMOLD] Verify your emil address");
			message.setText("Visit this link to verify your e-mail address."+crlf+"http://localhost:8080/GetOut/MailVerified?verify="+token+crlf+crlf+
			"Please do not reply to this notification, this inbox is not monitored."+crlf+"If you are having a problem, please email"+crlf+crlf+"Thank you for using the website!");
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}


	public void sendMailForResetPass(String mail, String token) {

		String from = "kaneko.naoki.0620@gmail.com"; //Sender's email

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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject("UnMOLD password reset");
			message.setText("http://localhost:8080/GetOut/VerifyResetPass?verify="+token);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}