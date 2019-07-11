package MyRPC;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于TCP协议实现RPC -- 服务提供者 ：server
 * @author admin
 *
 */
public class Provider {
    
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(808);
        Map<Object, Object> services = new HashMap<Object, Object>();  
        services.put(SayHelloService.class.getName(), new SayHelloServiceImpl());//用map储存service和其实现对象
        while(true) {
            System.out.println("服务提供者启动，等待客户端调用…………"); 
            Socket socket = server.accept();
            //读取服务信息
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            //接收数据：和发送时的顺序一一对应。
            String interfaceName = in.readUTF();//接口名称
            String methodName = in.readUTF();//方法名称
            Class<String[]>[] parameterTypes = (Class<String[]>[]) in.readObject();//参数类型
            Object  arguments = (Object) in.readObject();//参数
            System.out.println("客户端调用服务端接口" + interfaceName + "的" + methodName + "方法");
            //执行调用
            Class<?> serviceClass = Class.forName(interfaceName);//得到接口的class
            Object service = services.get(interfaceName);//取得服务实现的对象
            Method method = serviceClass.getMethod(methodName, parameterTypes);//获得要调用的方法
            Object result = method.invoke(service, arguments);//方法的invoke（类、参数）
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(result);
            System.out.println("服务端返回结果为：" + result);
//            server.close();
        }
    }
}
