package 重载与覆盖;

import java.io.IOException;

/**
 * 此类是：重载与覆盖（私有的不能覆盖）
 * 		覆盖：
 * 			权限要>=父类的方法
 * 			异常<=父类抛的异常
 * 		重载：
 * 			只要方法名相同其他的没有特殊要
 * @author hpc
 * @date 2016年12月9日 上午12:38:00
 */
public class App extends Bpp {

	
	/* 权限要>=父类的方法		异常<=父类抛的异常
	 */
	@Override
	public void bpp() throws IOException {
		System.out.println("bpp");
	}
	/**
	 * 只要方法名相同其他的没有特殊要
	 */
	public int bpp(String s){
		return 0;
	}
	public String bpp(String s,int a,double b){
		return "";
	}
}

class Bpp {
	void bpp() throws Exception {
		System.out.println("BPP");
	}
}