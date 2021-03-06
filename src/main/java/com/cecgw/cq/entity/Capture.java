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
 * @since 2018-11-27
 */
@Entity
@Table(name = "T_CAPTURE")
@Data
@NoArgsConstructor
public class Capture {
    @Id
    @GeneratedValue(generator = "timeID")
    @GenericGenerator(name = "timeID", strategy = "com.cecgw.cq.util.IdGen")
    private Long ID;
    private String tollgate_code;
    private String plate_color;
    private String pass_time;
    private String pic1_name;
    private String V2;
}
