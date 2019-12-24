package com.springdrools.springdrools.utils;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.utils.KieHelper;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-24
 * 描述:
 * 无状态的KieSession与有状态的KieSession无论是API的操作还是状态的保留都大不相同，StatelessKieSession封装
 * 了KieSession，是一个独立的功能，其主要目的是提供了更多的服务方式，使用StatelessKieSession时不需要再调用
 * dispose()方法。而且无状态会话不支持迭代插入，有状态调用规则从Java代码调用fireAllRules()方法开始；
 * 无状态调用规则从Java调用execute()方法开始。该方法是一次执行的，它将在内部实例化KieSession，
 * 并调用fireAllRules()方法，然后在finally中调用dispose()方法。所以在execute()之后不能再调用会话的其他操作。
 */
public class StatelessKieSessionUtils {


    /**
     * 创建StatelessKieSession
     * @param drlContent
     * @return
     */
    public static StatelessKieSession createStatelessKieSession(String drlContent){
        KieHelper kieHelper=new KieHelper();
        kieHelper.addContent(drlContent, ResourceType.DRL);
        KieBase kieBase=kieHelper.build();
        StatelessKieSession statelessKieSession=kieBase.newStatelessKieSession();
        return statelessKieSession;
    }


}
