package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

@Slf4j
public class ClassUtilTest {
    @Test
    public void extractPakageTset() {
        Set<Class<?>> classSet =  ClassUtil.extractPackageClass("com.lkh.entity");
        System.out.println(classSet);
        Assertions.assertEquals(4, classSet.size());
    }
}
