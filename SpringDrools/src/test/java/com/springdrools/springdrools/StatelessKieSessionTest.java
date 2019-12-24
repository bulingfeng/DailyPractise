package com.springdrools.springdrools;

import com.springdrools.springdrools.entity.Person;
import com.springdrools.springdrools.entity.School;
import com.springdrools.springdrools.utils.StatelessKieSessionUtils;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-24
 * 1. 每次执行一次execute方法，都会创建一个新的StatefulKnowledgeSession。
 * 2. KieSession执行fireAllRules()方法。
 * 3. 每次执行完成后都会调用“dispose(ksession);”方法。
 * 总结：无状态的规则不会出现类似迭代（产生笛卡儿积）的问题，它会适时创建和清空当前的KieSession。
 */
public class StatelessKieSessionTest {
    private static final String path="rules/stateless/";

    @Test
    public void testStatelessKieSession(){
        Person person=new Person();
        person.setAge(18);
        person.setName("peak");
        School school=new School();
        school.setClassName("三年一班");
        StatelessKieSessionUtils.actionStatelessKieSession(path+"Test.drl",school);
        StatelessKieSessionUtils.actionStatelessKieSession(path+"Test.drl",person);
    }

    /**
     * StatelessKieSession的批量执行
     * 个人理解：
     * StatelessKieSession的批量操作和KieSession的依次插入本质上差异不大。
     * 1：StatelessKieSession是自动的帮你执行了了kiesession.dispose()
     * 2：用KieSession用在规则关联关系比较强的业务下，而StatelessKieSession则保证每次操作都是独立的。
     */
    @Test
    public void testStatelessKieSessionBatch(){
        Person person=new Person();
        person.setAge(18);
        person.setName("peak");
        School school=new School();
        school.setClassName("三年一班");
        List list=new ArrayList();
        list.add(person);
        list.add(school);
        StatelessKieSessionUtils.actionStatelessKieSessionBatch(path+"Test.drl",list);
    }

}
