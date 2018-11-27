package com.cecgw.cq.repository;

import com.cecgw.cq.entity.Capture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-27
 */
public interface CaptureRep extends JpaRepository<Capture,Integer> {
}
