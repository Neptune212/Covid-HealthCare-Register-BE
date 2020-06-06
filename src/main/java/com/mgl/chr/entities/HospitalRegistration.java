package com.mgl.chr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HospitalRegistration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Column
    private String hospitalId;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String emailId;
    @Column
    private String zipCode;
    @Column
    private String city;
    @Column
    private String addressDetails;
    @Column
    private Double latitude;
    @Column
    private Double longitude;

    public String getWholeAddress() {
        return addressDetails + "," + city + "," + zipCode;
    }

}
