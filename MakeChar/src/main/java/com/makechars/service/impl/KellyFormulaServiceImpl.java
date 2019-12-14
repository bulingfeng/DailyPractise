package com.makechars.service.impl;

import com.makechars.constants.KellyConstants;
import com.makechars.model.LineChart;
import com.makechars.service.KellyFormulaService;
import com.makechars.utils.ChartUtils;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-11
 */
@Service
public class KellyFormulaServiceImpl implements KellyFormulaService {



    @Override
    public Map<String, Map<String, Double>> getChartByKellyFormula(String percent,String gains,String fileName) {



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
            if (chanceArray[randomNum]==0){
                totalMoney+=(tempMoney+tempMoney*Double.parseDouble(gains));
            }else {
                totalMoney-=tempMoney;
            }
            lineChart=new LineChart();
            lineChart.setValue(totalMoney);
            lineChart.setRowKey("pencent");
            lineChart.setColumnKey(i+"");
            lineChartList.add(lineChart);
        }


        Font font = new Font("宋体", Font.BOLD, 20);
        ChartUtils.createPort("凯利公式图表",lineChartList,"投资比例","钱(元)",font,fileName);
        return null;
    }
}
