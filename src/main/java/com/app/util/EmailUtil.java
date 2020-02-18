package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;

	public boolean send(String to, String subject, String text, String cc, String bcc, MultipartFile file) {
		boolean isSend = false;
		try {
			/* 1.Create Message */
			MimeMessage message= sender.createMimeMessage();

			/* 2.Helper Class Obj */
			MimeMessageHelper helper= new MimeMessageHelper(message, file!=null?true:false);
			/* 3.Set Data */
			helper.setTo(to);
			helper.setText(text);
			helper.setSubject(subject);
			if(cc!=null)
				helper.setCc(cc);

			if(bcc!=null)
				helper.setBcc(bcc);

			if(file!=null)
				helper.addAttachment(file.getOriginalFilename(), file);

			sender.send(message);
			isSend = true;

		} catch (Exception e) {
			isSend = false;
			e.printStackTrace();
		}

		return isSend;
	}

	public boolean send(String to, String subject, String text, String cc, String bcc) {
		return send(to, subject, text, cc, bcc, null);
	}

	public boolean send(String to, String subject, String text) {
		return send(to, subject, text, null, null, null);
	}

	public boolean send(String to, String subject, String text, MultipartFile file) {
		return send(to, subject, text, null, null, file);
	}
}
