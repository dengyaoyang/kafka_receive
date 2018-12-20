package com.cecgw.cq.util;

import com.alibaba.fastjson.JSONObject;
import com.cecgw.cq.entity.CaptureBo;

/**
 * @author dengyaoyang
 * @version V1.0
 * @since 2018-12-20
 */
public class DataSendUtils {
    private static final  String string = "{\n" +
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

    public static CaptureBo createCap(String str){
        return JSONObject.parseObject(str,CaptureBo.class);
    }

    public static CaptureBo createCapJson(String str){
        return JSONObject.parseObject(str,CaptureBo.class);
    }
}
