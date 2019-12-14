package com.makechars.utils;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-11
 */
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import com.makechars.constants.KellyConstants;
import com.makechars.model.LineChart;
import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
@Slf4j
public class ChartUtils {
    /**
     * 提供静态方法：获取报表图形3：折线图
     * @param title        标题
     * @param datas        数据
     * @param type        分类（第一季，第二季.....）
     * @param danwei    柱状图的数量单位
     * @param font        字体
     */
    public static void createPort(String title, List<LineChart> datas, String type, String danwei, Font font,String fileName){
        try {
            //种类数据集
            DefaultCategoryDataset ds = new DefaultCategoryDataset();


            for (LineChart lineChart : datas) {
                Double value=lineChart.getValue();
                String rowKey=lineChart.getRowKey();
                String columnKey=lineChart.getColumnKey();
                ds.setValue(value,rowKey,columnKey);
                log.info("value:%s,rowKey:%s,colunmKey:%s",value,rowKey,columnKey);
            }


            //创建折线图,折线图分水平显示和垂直显示两种
             JFreeChart chart = ChartFactory.createLineChart(title, type, danwei, ds,//2D折线图
                                                           PlotOrientation.VERTICAL,
                                                         true, true, true);

            //设置整个图片的标题字体
            chart.getTitle().setFont(font);

            //设置提示条字体
            font = new Font("宋体", Font.BOLD, 15);
            chart.getLegend().setItemFont(font);

            //得到绘图区
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            //得到绘图区的域轴(横轴),设置标签的字体
            plot.getDomainAxis().setLabelFont(font);

            //设置横轴标签项字体
            plot.getDomainAxis().setTickLabelFont(font);

            //设置范围轴(纵轴)字体
            font = new Font("宋体", Font.BOLD, 18);
            plot.getRangeAxis().setLabelFont(font);
            //存储成图片

            //设置chart的背景图片
//            chart.setBackgroundImage(ImageIO.read(new File("f:/test/1.jpg")));

            // plot.setBackgroundImage(ImageIO.read(new File("f:/test/2.jpg")));

            plot.setForegroundAlpha(1.0f);


            ChartUtilities.saveChartAsJPEG(new File(KellyConstants.IMAGE_PATH +fileName+".png"), chart, 800, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
