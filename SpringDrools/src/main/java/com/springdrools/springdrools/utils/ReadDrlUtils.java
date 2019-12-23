package com.springdrools.springdrools.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-23
 * 读取drl文件内的规则
 */
public class ReadDrlUtils {


    /**
     *
     * @param fileName
     * @return
     */
    public static String readDrlFile(String fileName) {
        InputStream inputStream=ReadDrlUtils.class.getClassLoader().getResourceAsStream("rules/"+fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer sb=new StringBuffer();
        String line=null;
        try {
            while ((line=br.readLine()) !=null){
                sb.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

}
