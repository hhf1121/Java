package MyRPC;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 基于TCP协议实现RPC -- 服务调用方：client
 * @author admin
 *
 */
public class Consumer {
    
    public static void main(String[] args) throws Exception {
        //接口名称
        String interfaceName = SayHelloService.class.getName();
        //需要执行远程的方法
        Method method = SayHelloService.class.getMethod("sayHello", String[].class);
        //传递到远程的参数
        String [] arr={"hello","hhf"};
        Object  arguments = arr;
        Socket socket = new Socket("127.0.0.1", 808);
        //将方法名和参数传递到远端
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeUTF(interfaceName);//接口名称
        out.writeUTF(method.getName());//方法名称
        out.writeObject(method.getParameterTypes());//方法参数类型
        out.writeObject(arguments);//传递的参数
        System.out.println("发送信息到服务端，发送的信息为:" + arguments);
        //从远端读取返回结果
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String result = (String) in.readObject();
        System.out.println("服务返回的结果为：" + result); 
//        socket.close();
    }
}