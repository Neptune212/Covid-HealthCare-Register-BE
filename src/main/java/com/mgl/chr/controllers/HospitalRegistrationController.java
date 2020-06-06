package com.mgl.chr.controllers;

import com.mgl.chr.entities.HospitalRegistration;
import com.mgl.chr.services.GeolocationService;
import com.mgl.chr.services.HospitalRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/chr/hospital/")
@RequiredArgsConstructor
@CrossOrigin
public class HospitalRegistrationController {

    private final HospitalRegistrationService hospitalRegistrationService;

    private final GeolocationService geolocationService;

    @PostMapping(value = "registration")
    public HospitalRegistration saveOrUpdate(@RequestBody HospitalRegistration hospitalRegistration) {
        log.debug("Received hospital registration {} ", hospitalRegistration.toString());

        Map<String, Double> latLong = geolocationService.getLatLong(hospitalRegistration.getWholeAddress());
        hospitalRegistration.setLatitude(latLong.get("lat"));
        hospitalRegistration.setLongitude(latLong.get("lng"));

        return hospitalRegistrationService.saveOrUpdate(hospitalRegistration);
    }

    @GetMapping(value = "registrations")
    public List<HospitalRegistration> getAll() {
        log.debug("Get All Hospitals");
        return hospitalRegistrationService.findAll();
    }

    @GetMapping(value = "registration/{hospitalId}")
    public HospitalRegistration getHospital(@PathVariable String hospitalId) {
        return hospitalRegistrationService.findByHospitalId(hospitalId);
    }

}
