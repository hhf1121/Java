package designModel.ProxyModel;

public class ProxyTest {
	
	public static void main(String[] args) {
		
		ProxyInterface proxyInterface = new WeddingCompany(new NormalHome());
		
		proxyInterface.marry();
		
	}
}
