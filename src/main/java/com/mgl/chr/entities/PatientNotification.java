package com.mgl.chr.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PatientNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @Column
    private String email;
    @Column
    private Boolean isNotified;
    @Column
    private LocalDateTime subscribedAt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "HospitalRecord_NotifyPatientRegister",
            joinColumns = {@JoinColumn(name = "NotifyPatientRegister_id")},
            inverseJoinColumns = {@JoinColumn(name = "HospitalRecord_id")})
    private Set<HospitalRecord> hospitalRecords = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientNotification that = (PatientNotification) o;
        return id == that.id &&
                email.equals(that.email) &&
                isNotified.equals(that.isNotified) &&
                subscribedAt.equals(that.subscribedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, isNotified, subscribedAt);
    }
    
    public PatientNotification(LocalDateTime subscribedAt, String email, Boolean isnotifed) {
		super();
		this.subscribedAt = subscribedAt;
		this.isNotified = isnotifed;
		this.email = email;
	}
}
