package 线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 此类是：线程的创建方式
 * 
 * @author hpc
 * @date 2016年12月9日 上午9:51:44
 */
public class App {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		deadlock();
	}

	/**
	 * 线程死锁
	 */
	public static void deadlock() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;)
					resource();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;)
					resource();
			}
		});
		thread.start();
		thread2.start();
	}

	public synchronized static void resource() {
		System.out.println(Thread.currentThread().getName());
	}

	/**
	 * 开启线程的三种实现方式
	 */
	@SuppressWarnings("unused")
	private static void threadImplenmentModel() {
		// executor的线程方式
		Executor executor = Executors.newScheduledThreadPool(10);
		executor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("sss");
			}
		});
		System.out.println("aaa");
		for (;;) {
			// 直接Runnable
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("直接Runnable");
				}
			}).start();
			// 实现runnable接口
			new Thread(new myThread()).start();
		}
	}
}

class myThread implements Runnable {
	public void run() {
		System.out.println("实现runnable接口");
	}
}