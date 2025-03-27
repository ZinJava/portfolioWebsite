package zinjava.madisonportfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zinjava.madisonportfolio.model.EmailRequest;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private JavaMailSender mailSender;

	@PostMapping("/send")
	public ResponseEntity<String> send(@RequestBody EmailRequest request) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(request.email());
			message.setTo("maziniqbal2005@gmail.com");
			message.setSubject(request.subject());
			message.setText(request.message());

			mailSender.send(message);
			return ResponseEntity.ok("Message sent successfully" + message);
		} catch (Exception e) {
			System.out.println("Email could not be sent");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email could not be sent");
		}
	}
}