package MyDubbo;

import Pojo.User;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws IOException {
        ApplicationConfig applicationConfig=new ApplicationConfig("server-config");
        ProtocolConfig protocolConfig=new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(-1);//-1、则默认端口
        RegistryConfig registryConfig=new RegistryConfig(RegistryConfig.NO_AVAILABLE);
        ServiceConfig<ApiServer> serviceConfig=new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setInterface(ApiServer.class);
        serviceConfig.setRef(new ApiServerImp());
        serviceConfig.export();
        System.out.println("服务启动...");
        System.in.read();
    }

}
