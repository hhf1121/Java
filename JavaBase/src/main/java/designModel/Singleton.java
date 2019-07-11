package designModel;

public class Singleton {

	//饿汉模式：直接创建对象
	private static Singleton instanceEH=new Singleton();
	
	//懒汉模式：创建对象
	public static Singleton instanceLH=null;
	//私有化构造器
	private Singleton(){}
	
	//饿汉模式：
	//共有的方法：直接返回对象实例
	public static Singleton getInstanceByEH(){
		return instanceEH;
	}
	
	//懒汉模式：
	//共有的方法：先判断，再返回对象实例
	public static Singleton getInstanceByLH(){
		if(instanceLH==null){
			synchronized (Singleton.class) {
				if(instanceLH==null){
					instanceLH=new Singleton();
				}
			}
		}
		return instanceLH;
	}
	
}
