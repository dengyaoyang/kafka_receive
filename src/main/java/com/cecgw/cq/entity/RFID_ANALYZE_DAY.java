package com.cecgw.cq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-15
 */
@Entity
@Table(name = "T_RFID_ANALYZE_DAY")
@Data
@NoArgsConstructor
public class RFID_ANALYZE_DAY {
    @Id
    @GeneratedValue(generator = "timeID")
    @GenericGenerator(name = "timeID", strategy = "com.cecgw.cq.util.IdGen")
    private long id;
    private String time;
    private String readerip;
    private String c1;
    private String c2;
    private String eid;
    private String color;
    private String nature;
    private String plate;
    private String vehicle;
    private String localization;
}
