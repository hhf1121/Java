package designModel.FactoryModel;

public class Factory {// 工厂类
	public static Car getCarInstance(String type) {
		
		Car c = null;
		if ("Benz".equals(type)) {
			c = new Benz();
		}
		if ("Ford".equals(type)) {
			c = new Ford();
		}
		return c;
	}
}
