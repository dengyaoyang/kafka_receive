package com.cecgw.cq.listen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cecgw.cq.entity.LINE_SPEED_CONF;
import com.cecgw.cq.entity.RFID_ANALYZE;

import com.cecgw.cq.entity.RFID_ANALYZE_DAY;
import com.cecgw.cq.entity.RfidMsg;

import com.cecgw.cq.repository.RfidAnalyseDayRep;
import com.cecgw.cq.repository.RfidAnalyseRep;
import com.cecgw.cq.util.JedisUtil;
import com.cecgw.cq.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-17
 */
@Component
public class KafkaListen {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(KafkaListen.class);
    @Autowired
    JedisUtil jedisUtil;
    private final static String TOPIC = "test277";
    @Autowired
    RfidAnalyseRep rfidAnalyseRep;
    @Autowired
    RfidAnalyseDayRep rfidAnalyseDayRep;
    String groupDate = new SimpleDateFormat("yyyy-MM-dd hh").format(new Date());

    @KafkaListener(topics = TOPIC,containerFactory = "ackContainerFactory")
    public void listen(ConsumerRecord<?, ?> record, Acknowledgment ack) {

        try {
            List<String> conf = jedisUtil.getList("speedConf");
            List<String> ipConf = jedisUtil.getList("ipConf");
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            if (kafkaMessage.isPresent()) {
                //过滤kafka无效数据
                RfidMsg rfidMsg = JSON.parseObject(kafkaMessage.get().toString(),RfidMsg.class);
                RFID_ANALYZE rfidAnalyze = new RFID_ANALYZE();
                rfidAnalyze.setC1(rfidMsg.getCONTENT1());
                rfidAnalyze.setC2(rfidMsg.getCONTENT2());
                rfidAnalyze.setTime(new Date(rfidMsg.getCOLLECT_TIME()));
                rfidAnalyze.setReaderip(rfidMsg.getREADERIP());
                rfidAnalyze.setColor(rfidMsg.getPlateColor());
                rfidAnalyze.setEid(rfidMsg.getEID());
                if (StringUtils.isNotBlank(rfidMsg.getCONTENT1())) {
                    rfidAnalyze.setLocalization(rfidMsg.getCONTENT1().substring(1,2));
                }
                rfidAnalyze.setNature(rfidMsg.getVEHICLE_USER_TYPE());
                rfidAnalyze.setPlate(rfidMsg.getPLATE_TYPE());
                rfidAnalyze.setVehicle(rfidMsg.getVEHICLE_TYPE());
                List<LINE_SPEED_CONF> lineSpeedConfs = JSONArray.parseArray(conf.toString(),LINE_SPEED_CONF.class);;
                boolean originFlag = ipConf.stream().anyMatch(e->e.equals(rfidAnalyze.getReaderip()));
                boolean startFlag = lineSpeedConfs.stream().anyMatch(e->e.getStart_ip().equals(rfidAnalyze.getReaderip()));
                boolean endFlag = lineSpeedConfs.stream().anyMatch(e->e.getEnd_ip().equals(rfidAnalyze.getReaderip()));
                if (originFlag){
                    jedisUtil.listAdd("origin_rifd"+groupDate, JSON.toJSONString(rfidAnalyze));
                }
                if (startFlag){
                    jedisUtil.listAdd("startRfid",JSON.toJSONString(rfidAnalyze));
                }
                if (endFlag){
                    jedisUtil.listAdd("endRfid",JSON.toJSONString(rfidAnalyze));
                }
                rfidAnalyseRep.save(rfidAnalyze);
                rfidAnalyseDayRep.save(changeObj(rfidAnalyze, TimeUtil.getTime(new Date(rfidMsg.getCOLLECT_TIME()),TimeUtil.FULL_CODE)));
            }
        }catch (Exception e){
            logger.error("rfid取数异常:"+e.getMessage());
            jedisUtil.listAdd(TOPIC+"_"+groupDate,record.value().toString());
//            consumer.seek(new TopicPartition("test277",record.partition()),record.offset());
        }finally {
            ack.acknowledge();
        }
    }

    public static int createId(Long id){
       String prefix =  String.valueOf(id).substring(0,5);
       String timeswap = String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
       StringBuffer buffer = new StringBuffer();
       buffer.append(prefix);
       buffer.append(timeswap.substring(0,timeswap.length()-5));
       return Integer.valueOf(buffer.toString());
    }

    private RFID_ANALYZE_DAY changeObj(RFID_ANALYZE rfidAnalyze,String time){
        RFID_ANALYZE_DAY rfidAnalyzeDay = new RFID_ANALYZE_DAY();
        rfidAnalyzeDay.setId(rfidAnalyze.getId());
        rfidAnalyzeDay.setC1(rfidAnalyze.getC1());
        rfidAnalyzeDay.setC2(rfidAnalyze.getC2());
        rfidAnalyzeDay.setTime(time);
        rfidAnalyzeDay.setReaderip(rfidAnalyze.getReaderip());
        rfidAnalyzeDay.setColor(rfidAnalyze.getColor());
        rfidAnalyzeDay.setEid(rfidAnalyze.getEid());
        rfidAnalyzeDay.setLocalization(rfidAnalyze.getLocalization());
        rfidAnalyzeDay.setNature(rfidAnalyze.getNature());
        rfidAnalyzeDay.setPlate(rfidAnalyze.getPlate());
        rfidAnalyzeDay.setVehicle(rfidAnalyze.getVehicle());
        return  rfidAnalyzeDay;
    }




    public static void main(String[] args) {
    String str = "{\"c1\": \"1111\",\"c2\": \"50010017191235\",\"color\": \"2\",\"eid\": \"504459995\",\"id\": 259689302304645130,\"localization\": \"\",\"nature\": \"\",\"plate\": \"02\",\"readerip\": \"1.1.1.1\",\"time\": \"Tue Nov 13 11:26:10 CST 2018\",\"vehicle\": \"2\"}";
        LINE_SPEED_CONF lineSpeedConf = JSON.parseObject(str,LINE_SPEED_CONF.class);
        JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(),"39.104.145.10", 6379, 10000, "majun123", 0);

        Jedis jedis = jedisPool.getResource();
        jedis.lpush("startRfid",str);
//        List<String> conf = jedis.lrange("speedConf", 0, -1);
//        List<LINE_SPEED_CONF> lineSpeedConf1 = JSONArray.parseArray(conf.toString(),LINE_SPEED_CONF.class);
//        System.out.println(lineSpeedConf1.size());
    }


}
