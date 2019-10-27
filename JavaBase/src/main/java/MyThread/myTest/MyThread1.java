package MyThread.myTest;

public class MyThread1 extends Thread {

	@Override
	public void run() {
		System.out.println("extends  Thread........");
	}

	public static void main(String[] args) throws InterruptedException {
		new MyThread1().start();
		Thread.sleep(5000);
	}
}
