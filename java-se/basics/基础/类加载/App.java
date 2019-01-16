package 类加载;

/**
 * 此类是：类的加载
 * 
 * @author hpc
 * @date 2016年12月9日 下午10:54:44
 */
public class App {
	public static void main(String[] args) throws Exception {
		// 通过反射初始化该类
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName("类加载.Bpp");
		// newInstance() 调用该方法是该类必须初始化过
		@SuppressWarnings("unused")
		Bpp bpp = (Bpp) clazz.newInstance();
		// 实例化 new 对象的时候该类有可能还没有初始化
		new Bpp();

	}
}

class Bpp {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
