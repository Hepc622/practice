package base;

/**
 * 此类是：java 的回收机制 只回收没有没引用的对象 在对象没有被引用，且内存不知的时候，jvm会去自动调用gc回收机制
 * 
 * @author hpc
 * @date 2016年12月9日 下午8:26:12
 */
public class Back {

	public static void main(String[] args) throws InterruptedException {
		int a=123;int b=321;
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a+"   "+b);

//		App app = new App();
		// 手动叫用回收机制，这时finalize方法是不会被执行的，因为该对象还有引用（app）
		// System.gc();
		new App();
		// 手动叫用回收机制，这时finalize方法是会被执行的，因为该对象这个没有引用
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.gc();
			}
		}).start();
		Thread.sleep(100);

	}

	/*
	 * 在调用gc回收之前会调用该方法 在finalize ( )方法中，你要指定在一个对象被撤消前必须执行的操作。
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("fff");
	}
}
