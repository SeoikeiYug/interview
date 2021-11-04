package com.genius.interview;

import com.genius.interview.design.factory.FactoryShare;
import com.genius.interview.design.factory.FactoryShareMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InterviewApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFactoryShare() {
        FactoryShareMethod factoryShareMethod = (FactoryShareMethod) applicationContext.getBean("factoryShareMethod");
        FactoryShare factoryShare = factoryShareMethod.getShareFunction(FactoryShareMethod.EnumShareType.SUCCESS_ORDER.getName());
        String successOrder = factoryShare.mainProcess("Success Order");
        System.out.println(successOrder);
    }

}
