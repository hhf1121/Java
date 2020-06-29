package Spring.Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("aop开始代理...");
        System.out.println("对象:"+object);
        System.out.println("参数："+ Arrays.toString(args));
        Object invoke = method.invoke(object, args);
        String s = invoke.toString();
        System.out.println("aop代理完毕...");
        return s;
    }

}
