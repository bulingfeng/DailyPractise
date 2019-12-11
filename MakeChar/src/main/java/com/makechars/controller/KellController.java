package com.makechars.controller;

import com.makechars.service.KellyFormulaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     */
    @GetMapping("/get")
    public void createChart(String percent,String gains){
        log.info("入参赢的概率percent:%$,收益gains:%s",percent,gains);
        kellyFormulaService.getChartByKellyFormula(percent,gains);
    }
}
