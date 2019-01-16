package 自动拆装箱;

/**
 * 此类是：java 自动拆装箱
 * 
 * @author hpc
 * @date 2016年12月9日 上午12:31:18
 */
public class App {
	/**
	 * int 类型自动拆装箱<br>
	 * 如果将int型的的变量[-128-128]<br>
	 * 赋值给integer类型就直接去引用变量池里的变量
	 */
	public static void main(String[] str) {
		Integer a = new Integer(3);
		// 如果将int型的的变量[-128-127]赋值给integer类型就直接去引用变量池里的变量
		Integer b = 3;

		// 如果将int型的的变量[-128-127]赋值给integer类型就直接去引用变量池里的变量
		Integer x = 20;
		Integer y = 20;

		Integer j = 128;
		Integer k = 128;
		int c = 3;
		System.out.println(a == b);
		// 自动拆装 ，将integer对象自动拆装成int类型
		System.out.println(a == c);
		System.out.println(b == c);
		System.out.println(x == y);
		System.out.println(j == k);
	}

}
