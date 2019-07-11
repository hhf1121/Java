package designModel.ProxyModel;


//结婚家庭的代码:
public class NormalHome implements ProxyInterface {

	@Override
	public void marry() {
		System.out.println("我们结婚啦～");
	}

}