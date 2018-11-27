package com.cecgw.cq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-27
 */
@Data
@AllArgsConstructor
public class FieldQueen {
    private String topicName;
    private int partition;
    private long offset;
}
