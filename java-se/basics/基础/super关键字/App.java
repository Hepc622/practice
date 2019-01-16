package super关键字;

import org.junit.Test;

/**
 * 此类是： super关键字
 * super关键字就相当于super对象 ,super()只能在之类构造函数中，且只能放在第一行
 * 1 super对象可以访问super的重载方法
 * 2 super对象可以访问super的构造方法
 * 3 super对象可以访问super的被隐藏的成员变量
 * （不是指私有的，而是被子类重写的父类成员变量，父类的成员变量就隐藏）
 *
 * @author hpc
 * @date 2016年12月21日 上午10:21:40
 */
public class App extends Bpp {

    public static void main(String[] args) {
        App inc = new App();
        int i = 1;
        inc.fermin(i);
        i = i - 1;
        System.out.println(i);
    }

    void fermin(int i) {
        i++;
    }

    public App() {
        super("asdf");
    }

    private int x = 20;
    @Test
    public void test() {
        super.fun(x + "");
        System.out.println(super.x);
    }
}

class Bpp {
    public int x = 22;

    public Bpp() {
        System.out.println("......Bpp");
    }

    public Bpp(String str) {
        System.out.println(str);
    }

    public void fun() {
        System.out.println("......fun1");
    }

    public void fun(String str) {
        System.out.println(str);
    }
}
