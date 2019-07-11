package MyThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {// 核心5个线程，最大10个线程，最大5个排队线程：最大处理线程：10+5=15个。超出15个，报错。
			MyTask myTask = new MyTask("线程：" + i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size());
		}
		executor.shutdown();
		
		while (!executor.isTerminated()) {
			System.out.println("已执行完的任务数目：" + executor.getCompletedTaskCount());
		}
	}
}

class MyTask implements Runnable {
	private String name;

	public MyTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("正在执行task " + name);
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + name + "执行完毕");
	}
}