package designModel;

public class Decorator implements Sourceable {
	
	private Sourceable decoratorSource;
	
	public  Decorator(Sourceable decoratorSource) {
		super();
		this.decoratorSource=decoratorSource;
	}

	@Override
	public void method() {
		System.out.println("before-------");
		decoratorSource.method();
		System.out.println("after-------");
	}

}
