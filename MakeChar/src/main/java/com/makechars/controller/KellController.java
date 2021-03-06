package com.makechars.controller;

import com.makechars.service.KellyFormulaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.makechars.constants.KellyConstants.WIN_PROBALIBY;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-11
 */
@RestController
@RequestMapping("/kelly")
@Slf4j
public class KellController {

    @Autowired
    private KellyFormulaService kellyFormulaService;


    /**
     *
     * @param percent 赢的概率
     * @param gains 获取的收益
     * @param gains 手里有的
     */
    @GetMapping("/get")
    public String createChart(String percent,String gains){
        log.info("入参赢的概率percent:{},收益gains:{}",percent,gains);
        return kellyFormulaService.getChartByKellyFormula(percent,gains);
    }

    /**
     * 根据凯利公式获取到完美的结果
     * @param gains
     */
    @GetMapping("/perfect")
    public void perfectKelly(String gains){
        log.info("入参赢的概率percent:%s,收益gains:%s",gains);
        // 计算应该按照最优的比例投资为
        double percentNum=WIN_PROBALIBY/100.0;
        double perfectPercent=((percentNum*3-(1-percentNum))/3.0)*100;
        kellyFormulaService.getChartByKellyFormula(perfectPercent+"",gains);
    }
}
