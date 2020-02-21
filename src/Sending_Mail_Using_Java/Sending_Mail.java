package Sending_Mail_Using_Java;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sending_Mail {
	
	public static void main(String[] args) throws AddressException, MessagingException {
		
		Mail_Sender("hi");
		
	}
	
	public static void Mail_Sender(String Message_Content) throws AddressException, MessagingException {
		Properties prop=new Properties();
		System.out.println("Preparing to send Email");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		String myacc="rraghavendraprasadgowda@gmail.com";
		String passwd="Polymerjs@1994";
		
		Session session=Session.getInstance(prop,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myacc, passwd);
			}
		});
		
		Message mess=new MimeMessage(session );
		mess.setFrom(new InternetAddress(myacc));
		mess.setRecipient(Message.RecipientType.TO, new InternetAddress(myacc));
		mess.setSubject("This is from Eclipse Java");
		mess.setText(Message_Content);
		
		Transport.send(mess);
		System.out.println("Message sent successfully");
	}

}
