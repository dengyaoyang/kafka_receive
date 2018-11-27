/**
  * Copyright 2018 bejson.com 
  */
package com.cecgw.cq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaptureBo {
    private String cjdid;
    private String driveStatus;
    private long id;
    private String identifyStatus;
    private boolean inFence;
    private long insertTime;
    private String laneDir;
    private String laneIndex;
    private int limitSpeed;
    private int mergeRetryCount;
    private long passTime;
    private String pic1Name;
    private int picNumber;
    private String plateCode;
    private String plateColor;
    private int plateConfidence;
    private int plateNumber;
    private String platePic;
    private String plateType;
    private int rearPlateConfidence;
    private String recordId;
    private String rectifyCode;
    private String tollgateCode;
    private int transFlag;
    private long updateTime;
    private String vehicleColor;
    private int vehicleLength;
    private int vehicleSpeed;
    private String vehicleType;

}