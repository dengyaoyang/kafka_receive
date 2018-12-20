package com.cecgw.cq;

import com.cecgw.cq.util.DataSendUtils;
import com.cecgw.cq.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaReceiveApplicationTests {

	@Autowired
	KafkaTemplate kafkaTemplate;

	@Test
	public void contextLoads() {
		String str = "{\n" +
				"\t\"cjdid\": \"\",\n" +
				"\t\"driveStatus\": \"0\",\n" +
				"\t\"id\": 259679926883459062,\n" +
				"\t\"identifyStatus\": \"0\",\n" +
				"\t\"inFence\": false,\n" +
				"\t\"insertTime\": 1542078984819,\n" +
				"\t\"laneDir\": \"1\",\n" +
				"\t\"laneIndex\": \"2\",\n" +
				"\t\"limitSpeed\": 80,\n" +
				"\t\"mergeRetryCount\": 0,\n" +
				"\t\"passTime\": 1542078982302,\n" +
				"\t\"pic1Name\": \"http://192.168.155.6:8083/192168155671420015400715/2018/11/13/11/HC131158159/11162230641122402.jpg?fid=850850\",\n" +
				"\t\"picNumber\": 2,\n" +
				"\t\"plateCode\": \"渝A00001\",\n" +
				"\t\"plateColor\": \"2\",\n" +
				"\t\"plateConfidence\": 95,\n" +
				"\t\"plateNumber\": 1,\n" +
				"\t\"platePic\": \"http://192.168.155.0:8083/192168155671420015400715/2018/11/13/11/HC131158159/Character11162230655452602.jpg?fid=850850\",\n" +
				"\t\"plateType\": \"02\",\n" +
				"\t\"rearPlateConfidence\": 0,\n" +
				"\t\"recordId\": \"4967340079\",\n" +
				"\t\"rectifyCode\": \"F000\",\n" +
				"\t\"tollgateCode\": \"HC131358159\",\n" +
				"\t\"transFlag\": 0,\n" +
				"\t\"updateTime\": 1542078984926,\n" +
				"\t\"vehicleColor\": \"Z\",\n" +
				"\t\"vehicleLength\": 0,\n" +
				"\t\"vehicleSpeed\": 28,\n" +
				"\t\"vehicleType\": \"1\"\n" +
				"}";
		String rfidMsg = "{\"ANTENNA\":\"1\",\"ATTACHMENT\":\"{}\",\"CARD_ID\":\"\",\"CARRY_CAPACITY\":\"\",\"COLLECT_TIME\":1542079570273,\"CONFIDENCE\":\"1.0\",\"CONTENT1\":\"渝BVY002\",\"CONTENT2\":\"50010017191245\",\"DEVICE_DESCRIPTION\":\"\",\"DEVICE_ID\":\"3117\",\"DEVICE_TYPE\":\"RFID\",\"DIRECTION\":\"北向\",\"DISCOVER_TYPE\":\"FIRST_FOUND\",\"DISPLACEMENT\":\"\",\"EID\":\"504459994\",\"EPC\":\"002501750000000000000000\",\"EXAMINE_EXPIRE_DATE\":\"\",\"FACTORY_DATE\":\"\",\"FIRST_DISCOVER_TIME\":\"2018-11-13 11:26:10.273\",\"FORCE_SCRAP_DATE\":\"\",\"LANE_NUMBER\":1,\"LAST_DISCOVER_TIME\":\"2018-11-13 11:26:10.273\",\"LOCATION\":\"\",\"PLATE_TYPE\":\"02\",\"POWER_RATING\":\"\",\"READER\":\"余松路_祥福小景_大庆村立交\",\"READERIP\":\"10.22.0.89\",\"RECEIVED_TIME\":\"2018-11-13 11:25:21.584\",\"RECORD_ID\":\"63862930\",\"RESULT\":\"0\",\"SOURCE\":\"cq_nms\",\"TIME\":\"2018-11-13 11:26:10.273\",\"USER126\":\"2eb0d00002721000d9012ff0\",\"USER92\":\"1bf117c0\",\"VEHICLE_COLOR\":\"\",\"VEHICLE_TYPE\":\"2\",\"VEHICLE_USER_TYPE\":\"\",\"cjdid\":\"ZCQ10711\",\"epcNatureCode\":20,\"epcPlateCode\":2,\"epcVehicleCode\":117,\"id\":259682382304645130,\"inFence\":false,\"insertTime\":1542079570237,\"mergeRetryCount\":0,\"plateColor\":\"2\",\"rectifyCode\":\"0000\",\"rectifyMark\":\"0000\"}";

//		kafkaTemplate.send("cap277", StringUtils.repChat(str));
		new Thread(()->{
			try {
				kafkaTemplate.send("test0001",str);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();


		new Thread(()->{
			try {
				kafkaTemplate.send("test0002",str);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}


}
