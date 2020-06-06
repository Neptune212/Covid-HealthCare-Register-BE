package com.mgl.chr.services;

import com.mgl.chr.entities.PatientNotification;
import com.mgl.chr.repositories.PatientNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduledJob {

    private final PatientNotificationRepository patientNotificationRepository;

    private final NotifyPatientService notifyPatientService;

    @Value("${chr.purge.subscriptions.expiryTimeByWeek}")
    private Integer expiryTimeByWeek;

    @Scheduled(cron = "${chr.purge.subscriptions.schedule-cron}")
    public void purgeSubscriptions() {
        List<PatientNotification> patientNotifications = patientNotificationRepository.deleteBySubscribedAtBefore(LocalDateTime.now().minusWeeks(expiryTimeByWeek));

        notifyOnUnsubscribe(patientNotifications);
    }

    public void notifyOnUnsubscribe(List<PatientNotification> patientNotifications) {
        List<String> hospitals = new ArrayList<>();

        patientNotifications.forEach(pf -> {
            hospitals.clear();
            pf.getHospitalRecords().forEach(hr -> hospitals.add(hr.getHospitalRegistration().getName()));

            notifyPatientService.onUnsubscribe(pf.getEmail(), hospitals);
        });
    }
}
