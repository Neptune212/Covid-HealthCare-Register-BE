package com.mgl.chr.repositories;

import com.mgl.chr.entities.HospitalRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface HospitalRegistrationRepository extends JpaRepository<HospitalRegistration, Long> {

    @Modifying
    @Transactional
    HospitalRegistration findByHospitalId(String hospitalId);
}
