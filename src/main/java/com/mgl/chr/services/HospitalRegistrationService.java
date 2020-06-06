package com.mgl.chr.services;

import com.mgl.chr.entities.HospitalRegistration;
import com.mgl.chr.repositories.HospitalRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalRegistrationService {

    private final HospitalRegistrationRepository hospitalRegistrationRepository;

    public HospitalRegistration saveOrUpdate(HospitalRegistration hospitalRegistration) {
        return hospitalRegistrationRepository.save(hospitalRegistration);
    }

    public List<HospitalRegistration> findAll() {
        return hospitalRegistrationRepository.findAll();
    }

    public HospitalRegistration findByHospitalId(String hospitalId) {
        return hospitalRegistrationRepository.findByHospitalId(hospitalId);
    }
}
