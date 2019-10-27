package MyThread.myTest;

public class MyTread2 implements Runnable{

	@Override
	public void run() {
		System.out.println(" implements Runnable ...");		
	}

	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new MyTread2()).start();
//		new Thread(new MyTread2()).run();
		Thread.sleep(5000);
	}
}
