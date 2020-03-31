package com.project.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.project.model.User;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	/*
	public void sendEmail(User user, int otp) {
		MimeMessage msg = mailSender.createMimeMessage();
		String msg1 = "Hi, "+user.getName()+"<br>Your verification code is :<b> "+otp+"</b>";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setSubject("OTP");
			helper.setFrom(new InternetAddress("aemarjn@gmail.com","Report Repo Verification"));
			helper.setTo(user.getEmail());
			helper.setText(msg1,true);
			mailSender.send(helper.getMimeMessage());
		}catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	}
	*/
	
	public void sendDetails(User user) {
		MimeMessage msg  = mailSender.createMimeMessage();
		String msg1="Hi, " + user.getName() + 
				"<br> Your account has been successfully verified and created.<br><b>Account Details:</b><br>" + 
				"<b>Mail id :</b>" + user.getEmail() + "<br>" + 
				"<b>User name :</b>" + user.getUsername() + "<br>" + 
				"<b>Password :</b>" + user.getPassword() + "<br><br>Thank you.";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setSubject("Account Created");
			helper.setFrom(new InternetAddress("aemarjn@gmail.com","Report Repo Account Created"));
			helper.setTo(user.getEmail());
			helper.setText(msg1,true);
			mailSender.send(helper.getMimeMessage());
		}catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	}
}