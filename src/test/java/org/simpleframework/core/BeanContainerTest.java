package org.simpleframework.core;

import com.lkh.controller.frontend.MainPageController;
import com.lkh.service.solo.HeadLineService;
import com.lkh.service.solo.impl.HeadLineServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

import java.lang.reflect.InvocationTargetException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class BeanContainerTest {
    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();
    }
    @DisplayName("加载目标类及其实例到BeanContainer：loadBeansTest")
    @Test
    @Order(1)
    public void loadBeansTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        System.out.println(beanContainer);
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.lkh");
        Assertions.assertEquals(4, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());



//        Class<BeanContainer> clazz = BeanContainer.class;
//        Constructor<BeanContainer> constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        BeanContainer beanContainer = constructor.newInstance();
//        BeanContainer beanContainer = BeanContainer.getInstance();
//        System.out.println(beanContainer);
//        System.out.println("========");
//        BeanContainer instance1 = beanContainer.getInstance();
//        System.out.println(instance == beanContainer);
//        System.out.println("===========");
//        System.out.println(instance);
//        System.out.println("=====");
//        Constructor<BeanContainer> constructor1 = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        BeanContainer beanContainer1 = constructor.newInstance();
//        BeanContainer instance11 = beanContainer.getInstance();
//        System.out.println(beanContainer1 == beanContainer);
//        System.out.println("===========");
//        System.out.println(instance11 == instance1);
//        System.out.println("=====");
//        ContainerHolder
//        Class<? extends BeanContainer> aClass = instance11.getClass();
//        aClass.getDeclaredField("")


//        测试反射
//        BeanContainer beanContainer = BeanContainer.getInstance();
//        System.out.println(beanContainer);
//        System.out.println("========");
//
//        //获取外部类
//        Class clzz = BeanContainer.class;
//        //获取外部类默认无参构造方法
//        Constructor con = clzz.getDeclaredConstructor();
//        con.setAccessible(true);
//        //实例一个外部类对象
//        BeanContainer outObj = (BeanContainer) con.newInstance();
//        //获取外部类内的所有内部类
//        Class innerClazz[] = clzz.getDeclaredClasses();
//        Class<BeanContainer> clazz = BeanContainer.class;
//        Constructor<BeanContainer> constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        BeanContainer instance = constructor.newInstance();
//        System.out.println(instance);
//        System.out.println("========");
//        for (Class c : innerClazz) {
//            Object[] enumConstants = c.getEnumConstants();
//            Field field = c.getDeclaredField("instance");
//            field.setAccessible(true);
//            for(Object obj: enumConstants){
//                field.set(obj, instance);
//            }
//        }
//
//        BeanContainer beanContainer1 = BeanContainer.getInstance();
//        System.out.println(beanContainer1);
//        System.out.println("========");

        // 着枚举类成员变量持有的容器   也无法保证单例啊

    }

    @DisplayName("根据类获取其实例：getBeanTest")
    @Order(2)
    @Test
    public void getBeanTest(){
        MainPageController controller = (MainPageController)beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, controller instanceof MainPageController);
//        DispatcherServlet dispatcherServlet = (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
//        Assertions.assertEquals(null, dispatcherServlet);
    }
    @DisplayName("根据注解获取对应的实例：getClassesByAnnotationTest")
    @Order(3)
    @Test
    public void getClassesByAnnotationTest(){
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(1, beanContainer.getClassesByAnnotation(Controller.class).size());
    }
    @DisplayName("根据接口获取实现类：getClassesBySuperTest")
    @Order(4)
    @Test
    public void getClassesBySuperTest(){
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(true, beanContainer.getClassesBySuper(HeadLineService.class).contains(HeadLineServiceImpl.class));
    }
}
