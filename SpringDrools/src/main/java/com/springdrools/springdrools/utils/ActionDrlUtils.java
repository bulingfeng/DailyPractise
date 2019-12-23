package com.springdrools.springdrools.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.drools.core.io.impl.ByteArrayResource;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaGroup;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;

import java.nio.charset.StandardCharsets;
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

        KieSession kieSession=createKieSession(drlContent);
        // 开始执行规则，并且获取到规则的返回值
        FactHandle factHandle = kieSession.insert(inputParams);
        // 查看执行了多少条规则
        int n = kieSession.fireAllRules();
        Map<String, Object> result = (Map<String, Object>) kieSession.getObject(factHandle);
        kieSession.dispose();
        log.info("执行了{}规则",n);
        return result;
    }

    /**
     * 执行agenda-group
     * @param drlContent
     * @param agendaGroupName
     */
    public static void actionRuleByAgendaGroup(String drlContent,String agendaGroupName){
        KieSession kieSession=createKieSession(drlContent);
        AgendaGroup agendaGroup = kieSession.getAgenda().getAgendaGroup(agendaGroupName);
        if (agendaGroup == null) {
            throw new RuntimeException("no agendaGroup: " + agendaGroupName);
        }
        agendaGroup.setFocus();
        int n = kieSession.fireAllRules();
        log.info("agenda-group 执行了{}规则",n);
        kieSession.dispose();
    }


    /**
     * 创建kieSession
     * @param drlContent
     * @return
     */
    private static KieSession createKieSession(String drlContent){
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
        return kieSession;
    }




}
