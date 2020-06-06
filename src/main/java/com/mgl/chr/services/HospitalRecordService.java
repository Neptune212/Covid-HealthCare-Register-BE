package com.mgl.chr.services;

import com.mgl.chr.entities.HospitalRecord;
import com.mgl.chr.repositories.HospitalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalRecordService {

    private final HospitalRecordRepository hospitalRecordRepository;

    private final NotifyPatientService notifyPatientService;

    public HospitalRecord saveOrUpdate(HospitalRecord hospitalRecord) {

        return hospitalRecordRepository.save(hospitalRecord);
    }

    public List<HospitalRecord> findAll() {
        return hospitalRecordRepository.findAll();
    }

    public void notify(HospitalRecord hospitalRecord) {
        final HospitalRecord record = hospitalRecordRepository.findById(hospitalRecord.getId()).get();

		if (record.getNotifyPatients() != null) {
			record.getNotifyPatients().forEach(patientNotification -> notifyPatientService
					.notifyOnAvailability(patientNotification.getEmail(), record.getHospitalRegistration().getName()));
		}
	}
}
