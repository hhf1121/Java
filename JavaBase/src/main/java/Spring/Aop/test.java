package Spring.Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {

    public static void main(String[] args) {
        //这样会在路径sun.misc.ProxyGenerator.saveGeneratedFiles下，输出代理class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        ClassLoader classLoader = IMyGetData.class.getClassLoader();
        Class<?>[] classes = new Class[]{IMyGetData.class};
        InvocationHandler myGetData = new MyInvocationHandler(new MyGetData());
        IMyGetData o = (IMyGetData) Proxy.newProxyInstance(classLoader, classes, myGetData);
        System.out.println(o.getData("我是入参"));
    }
}
