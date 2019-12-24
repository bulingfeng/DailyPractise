package com.springdrools.springdrools;

import com.springdrools.springdrools.entity.Person;
import com.springdrools.springdrools.utils.StatelessKieSessionUtils;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.StatelessKieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-24
 */
public class StatelessKieSessionTest {
    private static final String path="rules/stateless/";

    @Test
    public void testStatelessKieSession(){
        Person person=new Person();
        person.setAge(18);
        person.setName("peak");
        StatelessKieSessionUtils.actionSatelessKieSession(path+"Test.drl",person);
    }
}
