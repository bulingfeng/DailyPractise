package com.springdrools.springdrools.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.drools.core.io.impl.ByteArrayResource;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-23
 * 根据传入的drl内容，然后执行drools文件
 */
@Slf4j
public class ActionDrlUtils {

    /**
     * 带有输入参数的
     * @param drlContent 规则内容
     * @param inputParams 入参
     * @return
     */
    public static Map<String, Object> actionRule(String drlContent,Map<String,Object> inputParams){
        if (StringUtils.isBlank(drlContent))
            throw new NullPointerException("传入的规则为空");

        KnowledgeBuilder knowledgeBuilder= KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(new ByteArrayResource(drlContent.getBytes(StandardCharsets.UTF_8)), ResourceType.DRL);

        if (knowledgeBuilder.hasErrors()){
            log.warn(knowledgeBuilder.getErrors().toString());
        }

        // kbase is created
        KieBase kieBase = knowledgeBuilder.newKieBase();

        KieSession kieSession = kieBase.newKieSession();

        // 开始执行规则，并且获取到规则的返回值
        FactHandle factHandle = kieSession.insert(inputParams);
        // 查看执行了多少条规则
        int n = kieSession.fireAllRules();
        Map<String, Object> result = (Map<String, Object>) kieSession.getObject(factHandle);
        kieSession.dispose();
        log.info("执行了{}规则",n);
        return result;
    }



}
