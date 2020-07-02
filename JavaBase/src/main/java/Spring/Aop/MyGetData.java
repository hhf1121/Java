package Spring.Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyGetData implements IMyGetData {

    @Override
    public String getData(String info) {
        return info;
    }
}
