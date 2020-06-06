package com.mgl.chr.repositories;

import com.mgl.chr.entities.PatientNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientNotificationRepository extends JpaRepository<PatientNotification, Long> {

    @Modifying
    @Transactional
    List<PatientNotification> deleteBySubscribedAtBefore(LocalDateTime expiryDateTime);

}
