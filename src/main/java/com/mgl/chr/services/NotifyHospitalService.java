package com.mgl.chr.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyHospitalService {

	private final EmailService emailService;

	public void onSubscribe(String toEmail, String itemType) {
		StringBuilder messageBody = new StringBuilder();
		messageBody.append("Hi Team,").append(System.lineSeparator()).append(System.lineSeparator())
				.append("A Person is looking for \"").append(itemType).append("\". Please update portal, if \"")
				.append(itemType).append("\" is available.").append(System.lineSeparator())
				.append(System.lineSeparator()).append("Regards,").append(System.lineSeparator()).append("CHR Team");

		emailService.sendMail(toEmail, "Person looking for availability of " + itemType, messageBody.toString());
	}

}
