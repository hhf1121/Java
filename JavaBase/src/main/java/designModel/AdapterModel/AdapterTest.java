package designModel.AdapterModel;

public class AdapterTest {
	
	public static void main(String[] args) {
		Phone phone = new Phone();
		VoltageAdapter adapter = new VoltageAdapter();
		phone.setAdapter(adapter);
		phone.charge();
	}
}
