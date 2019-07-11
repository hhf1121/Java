package MyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.event.ListSelectionEvent;

public class TestThreadPool2 {
	public static void main(String[] args) {
		try {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 30, 1, TimeUnit.SECONDS,new LinkedBlockingQueue());
			
			List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>(9000);
			// 发送垃圾邮件, 用户名假设为4位数字
			for (int i = 1000; i < 10000; i++) {
				futures.add(executor.submit(
						new FictionalEmailSender(i + "@sina.com", "Knock, knock, Neo", "The Matrix has you...")));
			}
			// 提交所有的任务后,关闭executor
			System.out.println("Starting shutdown...");
			executor.shutdown();
			// 每秒钟打印执行进度
			while (!executor.isTerminated()) {
				executor.awaitTermination(1, TimeUnit.SECONDS);
				int progress = Math.round((executor.getCompletedTaskCount() * 100) / executor.getTaskCount());
				System.out
						.println(progress + "% done (" + executor.getCompletedTaskCount() + " 邮件已发送).");
			}
			// 现在所有邮件已发送完, 检查futures, 看成功发送的邮件有多少
			int errorCount = 0;
			int successCount = 0;
			for (Future<Boolean> future : futures) {
				if (future.get()) {
					successCount++;
				} else {
					errorCount++;
				}
			}
			System.out.println(successCount + " 成功发送, 但是 " + errorCount + " 失败.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
