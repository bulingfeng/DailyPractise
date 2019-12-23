package com.springdrools.springdrools;

import com.springdrools.springdrools.utils.ActionDrlUtils;
import com.springdrools.springdrools.utils.ReadDrlUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-23
 */
public class TestDrools {

    @Test
    public void testDrl(){
        String drlContent= ReadDrlUtils.readDrlFile("TestDrl.drl");
        Map<String,Object> inputParam=new HashMap<>();
        inputParam.put("test",true);
        Map<String, Object> result= ActionDrlUtils.actionAllRule(drlContent,inputParam);
        System.out.println("执行规则后的结果为:"+result);
    }

    @Test
    public void agendaGroup(){
        String drlContent= ReadDrlUtils.readDrlFile("AgendaGroup.drl");
        ActionDrlUtils.actionRuleByAgendaGroup(drlContent,"test");
    }

    @Test
    public void activationGroup(){
        String drlContent= ReadDrlUtils.readDrlFile("ActivationGroup.drl");
        ActionDrlUtils.actionRuleByActivationGroup(drlContent,"activation-group-test");
    }

    @Test
    public void someRule(){
        String drlContent= ReadDrlUtils.readDrlFile("SomeRule.drl");
        ActionDrlUtils.actionSomeRule(drlContent,"somerule-1");
    }

    @Test
    public void flowGroup(){
        String drlContent= ReadDrlUtils.readDrlFile("RuleFlowGroup.drl");
        ActionDrlUtils.actionRuleByAgendaGroup(drlContent,"ruleflow-1");
    }
}
