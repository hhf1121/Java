package MyDubbo;


import org.apache.dubbo.config.*;

public class Client {

    public static void main(String[] args) {
        ApplicationConfig applicationConfig=new ApplicationConfig("client-config");
        ReferenceConfig<ApiServerImp> referenceConfig=new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setInterface(ApiServer.class);
        referenceConfig.setUrl("dubbo://192.168.202.53:20880/MyDubbo.ApiServer");
        ApiServer apiServer = referenceConfig.get();
        System.out.println(apiServer.getUser(1L));

    }

}
