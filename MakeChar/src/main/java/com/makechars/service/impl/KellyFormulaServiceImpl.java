package com.makechars.service.impl;

import com.makechars.constants.KellyConstants;
import com.makechars.model.LineChart;
import com.makechars.service.KellyFormulaService;
import com.makechars.utils.ChartUtils;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-11
 */
@Service
public class KellyFormulaServiceImpl implements KellyFormulaService {



    @Override
    public String getChartByKellyFormula(String percent,String gains) {



        List<LineChart> lineChartList=new ArrayList<>();

        int[] chanceArray=new int[100];



        for (int i = 0; i < 100; i++) {
            // 0代表赢 1代表输
            if (i< KellyConstants.WIN_PROBALIBY){
                chanceArray[i]=0;
            }else {
                chanceArray[i]=1;
            }
        }

        Map<String,Double> map1=new HashMap<>();
        // 手里存在的本金
        double totalMoney=KellyConstants.FUND;
        Double percentNum=Double.parseDouble(percent);
        LineChart lineChart=null;
        // 按照胜率的标准进行1000次投资
        for (int i = 0; i <KellyConstants.COUNT ; i++) {
            // 拿出来一定比例的钱
            double tempMoney=totalMoney*(percentNum/100.0);

            int randomNum=(int)(Math.random()*100);
            if (totalMoney<1.0){
                totalMoney=0.0;
            }else {
                if (chanceArray[randomNum]==0){
                    totalMoney+=(tempMoney+tempMoney*Double.parseDouble(gains));
                }else {
                    totalMoney-=tempMoney;
                }
            }
            lineChart=new LineChart();
            lineChart.setValue(totalMoney);
            lineChart.setRowKey("pencent");
            lineChart.setColumnKey(i+"");
            lineChartList.add(lineChart);
        }

        Date now = new Date(); // 创建一个Date对象，获取当前时间
        // 指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddMMss");
        String fileName=f.format(now)+"-"+System.currentTimeMillis();

        Font font = new Font("宋体", Font.BOLD, 20);
        ChartUtils.createPort("凯利公式图表",lineChartList,"投资比例","钱(元)",font,fileName);
        return fileName;
    }
}
