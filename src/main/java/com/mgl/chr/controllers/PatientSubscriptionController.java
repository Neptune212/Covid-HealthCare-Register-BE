package com.mgl.chr.controllers;

import com.mgl.chr.dto.SubscribeRequest;
import com.mgl.chr.services.PatientSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chr/hospital/")
@RequiredArgsConstructor
@CrossOrigin
public class PatientSubscriptionController {

    private final PatientSubscribeService patientSubscribeService;


    @PostMapping("subscribe")
    public void subscribe(@RequestBody SubscribeRequest subscribeRequest) {
        patientSubscribeService.onSubscribe(subscribeRequest);
    }

    @PostMapping("unsubscribe")
    public void unsubscribe(@RequestBody SubscribeRequest subscribeRequest) {
        patientSubscribeService.onUnsubscribe(subscribeRequest);
    }
}
