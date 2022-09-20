package com.knoldus.springboot.emailApi.service;

import java.io.File;
import java.util.Objects;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/***
 * configured a public class EmailSenderService
 * for sending Simple Email using spring .
 *
 * @author shashikant
 * @version OepnJdk 11.0.0
 */
@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;

	/**
	 *  for sending Simple Email using spring .
	 *
	 * @param toEmail email id toWhom send.
	 * @param subject subject of mail.
	 * @param body   description of subject.
	 */
	public void sendSimpleEmail(String toEmail,
								String subject,
								String body
	) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("shashikanttanti0213@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Mail Send...");


	}

	/**
	 * sending simple email with following attachments.
	 *
	 * @param toEmail email id toWhom send.
	 * @param body    body of mail.
	 * @param subject  subject.
	 * @param attachment attach any attachment.
	 * @throws MessagingException
	 */
	public void sendEmailWithAttachment(String toEmail,
										String body,
										String subject,
										String attachment
	) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setFrom("shashikanttanti0213@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);

		FileSystemResource fileSystemResource=
				new FileSystemResource( new File(attachment));
		mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()),
				fileSystemResource
		);
		mailSender.send(mimeMessage);
		System.out.println("Mail with attachment sent..");
	}
}