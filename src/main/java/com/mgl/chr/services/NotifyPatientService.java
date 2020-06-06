package com.mgl.chr.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotifyPatientService {
	private final EmailService emailService;

	public void onSubscribe(String toEmail, List<String> hospitals) {
		StringBuilder messageBody = new StringBuilder();
		messageBody.append("Hi Sir/Madam,").append(System.lineSeparator()).append(System.lineSeparator())
				.append("Thanks for subscribing.").append(System.lineSeparator()).append(System.lineSeparator())
				.append("Following hospitals have been notified:").append(System.lineSeparator())
				.append(hospitals.toString()).append(System.lineSeparator()).append(System.lineSeparator())
				.append("Regards,").append(System.lineSeparator()).append("CHR Team");

		emailService.sendMail(toEmail, "Hospitals are notified", messageBody.toString());
	}

	@Async
	public void onUnsubscribe(String toEmail, List<String> hospitals) {
		StringBuilder messageBody = new StringBuilder();
		messageBody.append("Hi Sir/Madam,").append(System.lineSeparator()).append(System.lineSeparator())
				.append("You have been unsubscribed from following list of hospitals:").append(System.lineSeparator())
				.append(hospitals.toString()).append(System.lineSeparator()).append(System.lineSeparator())
				.append("Please visit CHR portal to subscribe again.").append(System.lineSeparator())
				.append(System.lineSeparator()).append("Regards,").append(System.lineSeparator()).append("CHR Team");

		emailService.sendMail(toEmail, "Unsubscribed Successfully", messageBody.toString());
	}

	public void notifyOnAvailability(String toEmail, String hospital) {
		StringBuilder messageBody = new StringBuilder();
		messageBody.append("Hi Sir/Madam,").append(System.lineSeparator()).append(System.lineSeparator())
				.append("Medical resources you were looking for are now available.").append(System.lineSeparator())
				.append(System.lineSeparator()).append("Following hospital(s) have availability")
				.append(System.lineSeparator()).append(hospital).append(System.lineSeparator())
				.append(System.lineSeparator()).append("Regards,").append(System.lineSeparator()).append("CHR Team");

		emailService.sendMail(toEmail, "Items are available", messageBody.toString());
	}
}
