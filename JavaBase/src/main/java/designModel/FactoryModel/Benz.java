package designModel.FactoryModel;

// 具体实现类
public class Benz implements Car {
   public void run() {
       System.out.println("Benz开始启动了。。。。。");
   }

   public void stop() {
       System.out.println("Benz停车了。。。。。");
   }
}
