package Spring.Aop;


import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class InvokeTest {

    static volatile List<Integer>  lists= Lists.newArrayList();
    @Before
    public void Before(){
        for (int i = 0; i < 5; i++) {
            lists.add(i);
        }
    }


    @Test
    public void test(){
        //必须在main方法中执行，直接用junit的test方法调用无法生成代理的class文件
        ClassLoader classLoader = IMyGetData.class.getClassLoader();
        Class<?>[] classes = new Class[]{IMyGetData.class};
        InvocationHandler myGetData = new MyInvocationHandler(new MyGetData());
        IMyGetData o = (IMyGetData) Proxy.newProxyInstance(classLoader, classes, myGetData);
        System.out.println(o.getData("我是入参"));
    }


    /**
     * 并发操作，导致遍历的时候，报了错。
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        new Thread(() -> {
            while (true){
                lists.forEach(o -> {
                    System.out.println(o);
                });
            }
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
//            ArrayList<String> list = Lists.newArrayList("A","B","C");
//            lists.addAll(list);
            lists.remove(1);
        }).start();
        Thread.sleep(Integer.MAX_VALUE);
    }


    @Test
    public void test2(){
        List s=Lists.newArrayList(1,2,3);
        getDeptNum(s);
        System.out.println("list："+s);
    }

    private List getDeptNum(List<Integer> s) {
        List list1=Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            if(i%5==0){
                list1.add(i);
            }
        }
//        this.lists=list1;
        s=list1;
        System.out.println(s);
        return list1;
    }


    @Test
    public void  test3(){
        Integer n = 3;
        System.out.println("Before change, n = " + n);
        changeData(n);
        System.out.println("After changeData(n), n = " + n);
    }

    private void changeData(int n) {
        n=10;
    }


}
