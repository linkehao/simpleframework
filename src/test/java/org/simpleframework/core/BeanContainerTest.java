package org.simpleframework.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
public class BeanContainerTest {
    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();
    }

    @Test
    public void loadBeansTest(){
//        System.out.println(beanContainer);
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.lkh");
        Assertions.assertEquals(3, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

}
