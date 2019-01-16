/**
 * 描述：
 * 作者：HPC
 * 时间：2018-12-09 17：59
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:provider.xml");
        context.start();
        System.out.println("启动结束,可以进行服务调用。按任意键退出...");
        System.in.read(); // 按任意键退出
    }
}
