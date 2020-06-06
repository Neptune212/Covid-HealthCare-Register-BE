package com.mgl.chr.utils;

import com.mgl.chr.entities.HospitalRecord;
import com.mgl.chr.entities.HospitalRegistration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitialData {

	public static final List<HospitalRecord> HOSPITAL_RECORDS = new ArrayList<>();

	static {
		HospitalRegistration hreg1 = new HospitalRegistration(null, "Max Shalimar Bagh110088", "Max Shalimar Bagh",
				"2323423234", "pandemichealthcareregister@gmail.com", "110088", "Delhi",
				"Max Super Speciality Hospital, Shalimar Bagh", 0.0, 0.0);

		HospitalRecord hr1 = new HospitalRecord(null, "COVID-19", "1", "1", "104", "104-BED-1-25", "Incliner Bed",
				"BED", 25, 10, LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 30),
				"Covid-19 isolation ward is separat", true, hreg1, null);
		HospitalRecord hr2 = new HospitalRecord(null, "COVID-19", "2", "2", "206", "206-OXVEN-1-25",
				"Oxygen Ventilator", "Ventilator", 25, 5, LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 30),
				"Covid-19 isolation ward is separat", true, hreg1, null);

		HospitalRegistration hreg2 = new HospitalRegistration(null, "Fortis Hospital 01110088", "Fortis Hospital 01",
				"7657675675", "pandemichealthcareregister@gmail.com", "110088", "Delhi",
				"Fortis Hospital, Shalimar Bagh", 0.0, 0.0);

		HospitalRecord hr3 = new HospitalRecord(null, "COVID-19", "4", "4", "411", "411-BED-26-50", "Bed", "BED", 25,
				20, LocalDate.of(2020, 6, 1), LocalDate.of(2020, 7, 10), "Separte Covid-19 wards", true, hreg2, null);
		HospitalRecord hr4 = new HospitalRecord(null, "COVID-19", "3", "3", "309", "309-OXVEN-1-15", "Ventilator",
				"Ventilator", 15, 10, LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 30), "Separte Covid-19 wards",
				true, hreg2, null);

		HOSPITAL_RECORDS.add(hr1);
		HOSPITAL_RECORDS.add(hr2);
		HOSPITAL_RECORDS.add(hr3);
		HOSPITAL_RECORDS.add(hr4);
	}

}
