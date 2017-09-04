package com.ebuy.util;

import java.util.*;

/**
 * 字符串工具类
 * Created by zhiming.wu on 2017/9/4.
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

    /**
     * 获取UUID
     *
     * @return uuid without -
     */
    public static String UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * JSON串转换为List
     *
     * @return List<Map<String,Object>> list
     */
    public static List<Map<String, Object>> stringToList(String text) {
        if (text == null || "".equals(text)) {
            return null;
        }
        text = text.trim();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (!"[]".equals(text)) {
            // 去除字符串空格
            text = text.replace(" ", "");
            // 替找字符串map标识
            text = text.replace("}, {", ";");
            text = text.replace("},{", ";");
            text = text.substring(2, text.length() - 2);
            // 获取map数组
            String[] strarray = text.split(";");

            Map<String, Object> map;
            // 遍历map数组字符串,并转换成map对象
            for (String strs : strarray) {
                String[] stMap = strs.split(",");
                map = new HashMap<String, Object>();
                for (String strMap : stMap) {
                    String[] sMap = strMap.split("=");
                    map.put(sMap[0], sMap[1]);
                }
                list.add(map);
            }
            return list;
        }
        return list;
    }
}
