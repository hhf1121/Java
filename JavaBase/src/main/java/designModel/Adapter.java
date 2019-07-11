package designModel;

public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("Adapter-Targetable--method2");
	}

}
