package com.springdrools.springdrools.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.io.impl.ByteArrayResource;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.ActivationGroup;
import org.kie.api.runtime.rule.AgendaGroup;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.utils.KieHelper;

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
    public static Map<String, Object> actionAllRule(String drlContent,Map<String,Object> inputParams){

//        KieSession kieSession=createKieSession(drlContent);
        KieSession kieSession=createKieSessionByKieHelper(drlContent);
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


    public static void actionRuleByActivationGroup(String drlContent,String activationGroupName){
        KieSession kieSession=createKieSession(drlContent);
        ActivationGroup activationGroup=kieSession.getAgenda().getActivationGroup(activationGroupName);
        if (activationGroup == null){
            throw new RuntimeException("no activationGroupName: " + activationGroupName);
        }
        int n = kieSession.fireAllRules();
        log.info("agenda-group 执行了{}规则",n);
        kieSession.dispose();
    }

    public static void actionSomeRule(String drlContent,String ruleName){
        KieSession kieSession=createKieSession(drlContent);
        int n = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter(ruleName));
        log.info("agenda-group 执行了{}规则",n);
        kieSession.dispose();
    }
    /**
     * 使用KnowledgeBuilder创建kieSession
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

    /**
     * 使用KieHelper来创建KieSession
     * @param drlContent
     * @return
     */
    private static KieSession createKieSessionByKieHelper(String drlContent){
        KieHelper kieHelper=new KieHelper();
        KieBase kieBase=null;
        kieHelper.addContent(drlContent,ResourceType.DRL);
        kieBase=kieHelper.build();
        return kieBase.newKieSession();
    }



}
