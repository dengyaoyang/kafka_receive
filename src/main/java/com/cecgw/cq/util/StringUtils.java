package com.cecgw.cq.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-23
 */
public class StringUtils {

    public static String repChat(String origin){
        return origin.replaceAll("\r\t\n",origin);
    }

}
