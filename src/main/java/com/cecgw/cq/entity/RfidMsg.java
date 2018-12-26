/**
  * Copyright 2018 bejson.com 
  */
package com.cecgw.cq.entity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Auto-generated: 2018-11-17 13:20:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class RfidMsg {

    private String ANTENNA;
    private String ATTACHMENT;
    private String CARD_ID;
    private String CARRY_CAPACITY;
    private long COLLECT_TIME;
    private String CONFIDENCE;
    private String CONTENT1;
    private String CONTENT2;
    private String DEVICE_DESCRIPTION;
    private String DEVICE_ID;
    private String DEVICE_TYPE;
    private String DIRECTION;
    private String DISCOVER_TYPE;
    private String DISPLACEMENT;
    private String EID;
    private String EPC;
    private String EXAMINE_EXPIRE_DATE;
    private String FACTORY_DATE;
    private Date FIRST_DISCOVER_TIME;
    private String FORCE_SCRAP_DATE;
    private int LANE_NUMBER;
    private Date LAST_DISCOVER_TIME;
    private String LOCATION;
    private String PLATE_TYPE;
    private String POWER_RATING;
    private String READER;
    private String READERIP;
    private Date RECEIVED_TIME;
    private String RECORD_ID;
    private String RESULT;
    private String SOURCE;
    private Date TIME;
    private String USER126;
    private String USER92;
    private String VEHICLE_COLOR;
    private String VEHICLE_TYPE;
    private String VEHICLE_USER_TYPE;
    private String cjdid;
    private int epcNatureCode;
    private int epcPlateCode;
    private int epcVehicleCode;
    private BigDecimal id;
    private boolean inFence;
    private long insertTime;
    private int mergeRetryCount;
    private String plateColor;
    private String rectifyCode;
    private String rectifyMark;

}