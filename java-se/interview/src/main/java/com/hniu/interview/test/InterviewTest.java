package com.hniu.interview.test;

import java.util.Arrays;
import java.util.Random;

public class InterviewTest {
	private static User[] users;

	/**
	 * 
	 * @author 何鹏程 内部类 类的加载顺序 static 修饰的-> {} -> 成员变量 -> main
	 */
	static class t {
		private static final String a = "1";// 1

		t() {
			System.out.println(a + b);// 6 这个时候才有this
		}

		private String b = "2"; // 3
		static {
			System.out.println("-2-");// 2
		}
		{
			System.out.println(b);// 4
		}
		{
			System.out.println(a);// 5
		}

	}
	public static void main(String[] args) {
		//InterviewTest i = new InterviewTest();
		// i.test2();
		// new t(); static方法里没有this
		//new t();
		Random random = new Random();

		System.out.println(random.nextInt(35));
	}

	/**
	 * int 类型自动拆装箱<br>
	 * 如果将int型的的变量[-128-128]<br>
	 * 赋值给integer类型就直接去引用变量池里的变量
	 */
	public void test2() {
		Integer a = new Integer(3);
		// 如果将int型的的变量[-128-128]赋值给integer类型就直接去引用变量池里的变量
		Integer b = 3;

		// 如果将int型的的变量[-128-128]赋值给integer类型就直接去引用变量池里的变量
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

	/**
	 * 阶乘 递归算法<br>
	 * 跳出多层for循环 xxx: for(){ break xxx;}<br>
	 * 自定义数组比较器 实现comparable接口<br>
	 * 位移算法 >> (右移) <<（左移）<br>
	 * switch的允许case类型 char short byte<br>
	 */
	public void test1() {
		// 2乘多少等于8效率最高？
		System.out.println(2 << 2);
		// 跳出所有循环的方式
		ok: for (int i = 0; 1 == 1; i++) {
			for (int j = 0; 1 == 1; j++) {
				System.out.println(i + "    " + j);
				if (j == 1000) {
					break ok;
				}
			}
		}
		char x = '恩';
		// switch 可以判断字符，char 是4字节,switch只能接受short,char,byte
		switch (x) {
		case '我':
			System.out.println('我');
			break;
		case '爱':
			System.out.println('爱');
			break;
		case '你':
			System.out.println('你');
			break;
		default:
			System.out.println("啥都没有");
		}

		users = new User[5];
		users[0] = new User(21, "hpc", "nang");
		users[1] = new User(23, "hyy", "nang");
		users[2] = new User(22, "hwl", "nang");
		users[3] = new User(24, "hjx", "nang");
		users[4] = new User(25, "hcw", "nang");
		Arrays.sort(users);

		for (User u : users) {
			System.out.println(u.toString());
		}
		System.out.println(jc(5));

	}

	static Long result;

	public static Long jc(int x) {
		if (x == 1 || x == 0)
			return (long) 1;
		else
			result = jc(x - 1) * x;
		return result;
	}
}

class User implements Comparable {
	private int age;
	private String name;
	private String sex;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User(int age, String name, String sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}

	public int compareTo(Object o) {
		User u = (User) o;
		return this.age < u.age ? 1 : this.age == u.age ? 0 : -1;
	}

}

abstract class father {

	private String name = "father";
}

class son extends father implements i {
	public String name = "son";

	public void test() {
	}

	@Override
	public void getName() {
	}
}

interface i {
	public void getName();
}