package com.mgl.chr.dto;

import com.mgl.chr.entities.HospitalRecord;
import lombok.Data;

import java.util.List;

@Data
public class SubscribeRequest {

    String email;

    List<HospitalRecord> hospitalRecords;
}
