package com.cecgw.cq.util;


import java.io.UnsupportedEncodingException;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-12-05
 */
public class Decode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String originCode = "测试乱码";
        String code = new String(originCode.getBytes(),"ISO-8859-1");
        System.out.println(code);
    }

}
