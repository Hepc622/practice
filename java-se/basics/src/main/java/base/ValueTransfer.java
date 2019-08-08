package base;

/**
 * 此类是：值传递！Java中只有按值传递，没有按引用传递！
 * 详细解释：<a>http://guhanjie.iteye.com/blog/1683637</a>
 *
 * @author hpc
 * @date 2016年12月8日 下午11:42:20
 */
public class ValueTransfer {
    static String str = "11";
    static int[][] i = {{111, 23, 4, 65}};

    static int num = 5;

    public static void main(String[] args) {//入栈
//        String x="x";// 在栈中分配地址
//        String y="y";
//        operator(x,y);// 入栈,运行完弹栈
//        System.out.println(x+"_"+y);//x_y
//        chanceBasicType("hpc");
//        System.out.println(App.str);
//        Object o = new Object();
//        System.out.println(o);
//        obj(o);
//        System.out.println(o);
        int x=0,y=1;
        changeInteger(x,y);
        System.out.printf(x+":"+y);
    }
    public static void changeInteger(Integer ... i){
        i[0]=2;
        i[1]=3;
    }
    // 给形参分配地址，当传入参数时会指向传入的参数地址
    public static void operator(String x, String y) {//这里是传递地址值还是值？
        // 运行前x仍然是指向 main中的x地址
        x = x + y;// 运行完x指向的是另一个地址
        System.out.println(x);//输出为xy
        // 运行前x仍然是指向 main中的y地址
        y = x;// 运行完y指向的地址是与x一样
        System.out.println(y);//输出为xy
    }

    public static void chanceBasicType(String str) {
        ValueTransfer.str = "22";
    }

    public static void chanceObjectType(int[] str) {
        str[0] = 666;
    }
    public static void obj(Object o){
    	o = new Object();
    	System.out.println(o);
    }
    

}

/**
 * 此类是：为枚举，调用它的枚举时，会调用枚举数对应次数的构造函数次数
 *
 * @author hpc
 * @date 2016年12月13日 上午10:21:39
 */
enum Enum {
    RED, PINK, GREEN;

    private Enum() {
        System.out.println("eumn");
    }
}

class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};
    String x = new String("123");

    public String getX() {
        return x;
    }

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}

class Cpp {
    String y = new String("123");

    public String getY() {
        return y;
    }

}