package Spring.Aop;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class InvokeTest {


    @Test
    public void test(){
        //必须在main方法中执行，直接用junit的test方法调用无法生成代理的class文件
        ClassLoader classLoader = IMyGetData.class.getClassLoader();
        Class<?>[] classes = new Class[]{IMyGetData.class};
        InvocationHandler myGetData = new MyInvocationHandler(new MyGetData());
        IMyGetData o = (IMyGetData) Proxy.newProxyInstance(classLoader, classes, myGetData);
        System.out.println(o.getData("我是入参"));
    }

}
