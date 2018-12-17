package com.cecgw.cq.controller;

import com.alibaba.fastjson.JSON;
import com.cecgw.cq.entity.CharData;
import com.cecgw.cq.entity.ResultModel;
import com.cecgw.cq.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-12-13
 */
@Controller
public class ChartController {

    @Autowired
    RestTemplate restTemplate;

    int k = 10;
    @RequestMapping("/getLineChart")
    public String getLineChart(){
        return "/line_chart";
    }

    @RequestMapping("/getJsonData")
    @ResponseBody
    public String getJsonData(){
        ResponseEntity<ResultModel> response =  restTemplate.getForEntity("http://localhsot:8081/dz/rfidanalysz/countjson", ResultModel.class);
        CharData charData = new CharData();
        charData.setCount(response.getBody().getCode());
        charData.setTime(TimeUtil.getTime(new Date(),"yyyy-MM-dd hh:mm:ss"));
        return JSON.toJSONString(charData);
    }
}
