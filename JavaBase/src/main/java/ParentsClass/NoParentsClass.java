package ParentsClass;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 打破双亲委派
 */
class MyClassLoader extends ClassLoader{

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }
    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name
                + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节 数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }


    /**
     *
     *
    * 重写类加载方法，实现自己的加载逻辑，不委派给双亲加载
     * * @param name
     * * @param resolve
     * * @return
     * * @throws ClassNotFoundException
     * */
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                //非自定义的类还是走双亲委派加载   Prohibited package name: java.lang
                //比如：Object类还用java.lang包的。
                if (!name.startsWith("ParentsClass.User")){
                    c = this.getParent().loadClass(name);
                }else
                    {
                    c = findClass(name);
                }
                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}




public class NoParentsClass {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载 器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        //D盘创建 目录，将User类的复制类User.class丢入该目录(D:test/ParentsClass/)
        Class clazz = classLoader.loadClass("ParentsClass.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("toSay", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());

    }

}

