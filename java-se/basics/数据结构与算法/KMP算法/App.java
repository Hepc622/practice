package KMP算法;

/**
 * 此类是：KMP算法
 * 
 * @author hpc
 * @date 2016年12月19日 下午7:58:48
 */
public class App {
	public static void main(String[] args) {
		String s = "saflaaaaajashpclsadfoihpclkdsaoihpc";
		String t = "aaaaajashpc";
		int[] next = new int[t.length()];
		getNext(t.toCharArray(), next);
		for (int index : next) {
			System.out.print(index + ",");
		}
		kmp(s.toCharArray(), t.toCharArray(), next);
	}

	public static void getNext(char[] str, int[] next) {
		int j = 0, k = -1;
		next[0] = -1;
		while (j < str.length - 1) {
			if (k == -1 || str[j] == str[k]) {
				k++;j++;
				if (str[j] != str[k])
					next[j] = k;
				else
					next[j] = next[k];
			} else {
				k = next[k];
			}
		}
	}

	public static void kmp(char[] s, char[] t, int next[]) {
		int x = 0, j = 0, y = 0;
		while (x < s.length && j < t.length) {
			if (j == -1 || s[x] == t[j]) {
				x++;
				j++;
			} else {
				j = next[j];
			}

//			System.out.println(y++);
		}
		if (j == t.length) {
			System.out.println(x - t.length);
		} else {
			System.out.println(-1);
		}
	}
}
