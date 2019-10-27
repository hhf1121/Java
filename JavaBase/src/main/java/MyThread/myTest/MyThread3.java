package MyThread.myTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * jdk1.5之后：Callable实现多线程
 * @author hhf
 *
 */
//泛型+返回值+异步
public class MyThread3 implements Callable<String>{

	//回调方法
	@Override
	public String call() throws Exception {
		System.out.println("多线程任务start...");
		return "implements Callable<String> ...";
	}

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<>(new MyThread3());
		new Thread(futureTask).start();
//		futureTask.cancel(false); //设置为false，就不能获取返回值
		System.out.println(futureTask.get());
		Thread.sleep(5000);
	}
	
}
