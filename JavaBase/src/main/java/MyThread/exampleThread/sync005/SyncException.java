package MyThread.exampleThread.sync005;
/**
 * synchronized异常
 * @author alienware
 *
 */
public class SyncException {

	private int i = 0;
	public synchronized void operation(){
		while(true){
			try {
				i++;
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + " , i = " + i);
				if(i == 10){
					Integer.parseInt("a");
//					throw new RuntimeException();
				}
			} catch (InterruptedException e) {// 抛出此异常之后，可中断线程.     其余的异常捕获不能中断线程
				e.printStackTrace();
				//处理一些业务逻辑
				//....
				System.out.println("---------------");
			}
		}
	}
	
	public static void main(String[] args) {
		
		final SyncException se = new SyncException();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				se.operation();
			}
		},"t1");
		t1.start();
	}
	
	
}
