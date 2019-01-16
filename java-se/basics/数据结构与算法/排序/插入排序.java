package 排序;

import java.util.Arrays;

/**
 * 此类是：插入排序法
 * 
 * @author hpc
 * @date 2016年12月26日 下午6:18:39
 */
public class 插入排序 {
	public static void main(String[] args) {
		Integer[] x = { 21, 4, 1, 54, 76, 3, 45, 1, 65, 223, 0 };
		paixu(x);
		for (int i = 0; i < x.length; i++) {
			if (i!=0)
				System.out.print(",");
			System.out.print(x[i]);
		}
	}

	/**
	 * 对数组进行排序
	 */
	public static void paixu(Integer[] o) {
		for (int i = 0; i < o.length; i++) {
			// 将i取出来，存储起来
			Integer in = o[i];
			int y = i - 1;// 将下标移至到前一位
			while (y >= 0 && in < o[y]) {
				o[y + 1] = o[y];// 将位置向后移动一位
				y--;// 将下标减1，再进行比较，如果小于就将大于它的下标向后移
			}
			o[y + 1] = in;// 将值复制给空出来的那个值
		}
	}
}