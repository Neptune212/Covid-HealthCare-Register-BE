package com.mgl.chr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HospitalRecord implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column
	private String pandemicType;
	@Column
	private String floor;
	@Column
	private String section;
	@Column
	private String room;
	@Column
	private String itemId;
	@Column
	private String itemName;
	@Column
	private String itemType;
	@Column
	private Integer itemCount;
	@Column
	private Integer availableCount;
	@Column
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate availableFrom;
	@Column
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate availableTill;
	@Column(columnDefinition = "TEXT")
	private String note;
	@Column
	private Boolean notifyWhenUserSubscribe;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "HospitalRecord_id")
	private HospitalRegistration hospitalRegistration;

	@ManyToMany(mappedBy = "hospitalRecords")
	@JsonIgnore
	private Set<PatientNotification> notifyPatients = new HashSet<>();

}
