package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.MailRequest;
import net.javaguides.springboot.dto.MailResponse;
import net.javaguides.springboot.service.EmailService;

@RestController
public class MailController {
	
	@Autowired
	private EmailService service;
	
	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		//here with the help of map we can sent key value dynamic data
		model.put("name", request.getName());
		model.put("location", "Bangalore,India");
		model.put("signature", "saumyaranajn");
		return service.sendEmail(request, model);

	}

}
