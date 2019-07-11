package MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool implements Runnable {

	private String name;
	
	public MyThreadPool(){}
	
	public MyThreadPool(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		System.out.println("线程工作..."+name);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ThreadPoolExecutor ThreadPoolExecutor=new ThreadPoolExecutor(1, 1, 0L,TimeUnit.MILLISECONDS , new LinkedBlockingQueue<Runnable>());
		
		 ThreadPoolExecutor.submit(new MyThreadPool("submit"));//submit:Runnable/Callable
		 
		 ThreadPoolExecutor.execute(new MyThreadPool("execute"));//execute:Runnable
		
	}
}
