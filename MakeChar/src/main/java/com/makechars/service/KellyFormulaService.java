package com.makechars.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-11
 */
public interface KellyFormulaService {
    Map<String, Map<String, Double>> getChartByKellyFormula(String percent,String gains,String fileName);
}
