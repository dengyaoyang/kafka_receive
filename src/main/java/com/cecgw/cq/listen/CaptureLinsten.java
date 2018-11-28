package com.cecgw.cq.listen;

import com.alibaba.fastjson.JSON;
import com.cecgw.cq.entity.Capture;
import com.cecgw.cq.entity.CaptureBo;
import com.cecgw.cq.repository.CaptureRep;
import com.cecgw.cq.util.JedisUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-27
 */
@Component
public class CaptureLinsten {
    @Autowired
    CaptureRep captureRep;
    @Autowired
    JedisUtil jedisUtil;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(CaptureLinsten.class);
    String groupDate = new SimpleDateFormat("yyyy-MM-dd hh").format(new Date());

    private static final String TOPIC = "cap277";
    @KafkaListener(topics = TOPIC, containerFactory = "ackContainerFactory")
    public void capListen(ConsumerRecord<?, ?> record, Acknowledgment ack){
        Optional<?> optional = Optional.ofNullable(record.value());
        List<String> codes = jedisUtil.getList("tollgateCode");
        try {
            if (optional.isPresent()){
                String capJson = optional.get().toString();
                CaptureBo captureBo = JSON.parseObject(capJson,CaptureBo.class);
                Capture capture = changeCapObj(captureBo);
                //如果跟配置中的数据匹配就SAVE
                boolean flag = codes.stream().anyMatch(n->n.equals(capture.getTollgate_code()));
                if (flag){
                    captureRep.save(capture);
                }
            }
        }catch (RuntimeException e){
            logger.error("cap取数异常:"+e.getMessage());
            jedisUtil.listAdd(TOPIC+"_"+groupDate,record.value().toString());
        }finally {
            ack.acknowledge();
        }

    }

    private Capture changeCapObj(CaptureBo captureBo){
        Capture capture = new Capture();
        capture.setID(captureBo.getId());
        capture.setFX(captureBo.getLaneDir());
        capture.setPass_time(String.valueOf(captureBo.getPassTime()));
        capture.setPic1_name(captureBo.getPic1Name());
        capture.setPlate_color(captureBo.getPlateColor());
        capture.setTollgate_code(captureBo.getTollgateCode());
        capture.setV2(captureBo.getPlateCode());
        return capture;
    }
}
