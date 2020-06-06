package com.mgl.chr.controllers;

import com.mgl.chr.entities.HospitalRecord;
import com.mgl.chr.services.GeolocationService;
import com.mgl.chr.services.HospitalRecordService;
import com.mgl.chr.utils.InitialData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/chr/hospital/")
@RequiredArgsConstructor
@CrossOrigin
public class HospitalRecordController {

	private final HospitalRecordService hospitalRecordService;

	private final GeolocationService geolocationService;

	@PostMapping(value = "record")
	public HospitalRecord save(@RequestBody HospitalRecord hospitalRecord) {
		log.debug("Received hospital record {}", hospitalRecord);

		Map<String, Double> latLong = geolocationService
				.getLatLong(hospitalRecord.getHospitalRegistration().getWholeAddress());
		hospitalRecord.getHospitalRegistration().setLatitude(latLong.get("lat"));
		hospitalRecord.getHospitalRegistration().setLongitude(latLong.get("lng"));

		final HospitalRecord record = hospitalRecordService.saveOrUpdate(hospitalRecord);

		if (Optional.of(hospitalRecord.getId()).isPresent() && hospitalRecord.getAvailableCount() > 0) {
			hospitalRecordService.notify(hospitalRecord);
		}

		return record;
	}

	@PutMapping(value = "updatedRecord")
	public HospitalRecord update(@RequestBody HospitalRecord hospitalRecord) {
		log.debug("Received hospital record {}", hospitalRecord);

		Map<String, Double> latLong = geolocationService
				.getLatLong(hospitalRecord.getHospitalRegistration().getWholeAddress());
		hospitalRecord.getHospitalRegistration().setLatitude(latLong.get("lat"));
		hospitalRecord.getHospitalRegistration().setLongitude(latLong.get("lng"));

		final HospitalRecord record = hospitalRecordService.saveOrUpdate(hospitalRecord);

		if (Optional.of(hospitalRecord.getId()).isPresent() && hospitalRecord.getAvailableCount() > 0)
			hospitalRecordService.notify(hospitalRecord);

		return record;
	}

	@GetMapping(value = "records")
	public List<HospitalRecord> getAll() {
		return hospitalRecordService.findAll();
	}

	@GetMapping(value = "init")
	public String init() {
		InitialData.HOSPITAL_RECORDS.forEach(this::save);
		return "OK";
	}

}
