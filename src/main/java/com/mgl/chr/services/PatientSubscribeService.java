package com.mgl.chr.services;

import com.mgl.chr.dto.SubscribeRequest;
import com.mgl.chr.entities.PatientNotification;
import com.mgl.chr.repositories.HospitalRecordRepository;
import com.mgl.chr.repositories.PatientNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientSubscribeService {

	private final PatientNotificationRepository patientNotificationRepository;
	private final HospitalRecordRepository hospitalRecordRepository;

	private final NotifyPatientService notifyPatientService;

	private final NotifyHospitalService notifyHospitalService;

	public void onSubscribe(SubscribeRequest subscribeRequest) {
		PatientNotification patientNotification = new PatientNotification(LocalDateTime.now(),
				subscribeRequest.getEmail(), false);
		if (Optional.of(subscribeRequest.getHospitalRecords()).isPresent()) {

			patientNotification.getHospitalRecords()
					.addAll(hospitalRecordRepository.saveAll(subscribeRequest.getHospitalRecords()));
			patientNotificationRepository.save(patientNotification);

			List<String> hospitals = new ArrayList<>();
			subscribeRequest.getHospitalRecords()
					.forEach(hospitalRecord -> hospitals.add(hospitalRecord.getHospitalRegistration().getName()));

			notifyPatientService.onSubscribe(subscribeRequest.getEmail(), hospitals);

			subscribeRequest.getHospitalRecords().forEach(hospitalRecord -> notifyHospitalService
					.onSubscribe(hospitalRecord.getHospitalRegistration().getEmailId(), hospitalRecord.getItemName()));

		}
	}

	public void onUnsubscribe(SubscribeRequest subscribeRequest) {
		// TO DO
	}

}
