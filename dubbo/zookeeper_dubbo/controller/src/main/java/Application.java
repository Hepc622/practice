/**
 * 描述：
 * 作者：HPC
 * 时间：2018-12-09 17：59
 */

import com.home.service.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        DubboService userService = (DubboService) context.getBean("userService");
        String hpc = userService.getName("hpc");
        System.out.println(hpc);
        String zll = userService.getName("zll");
        System.out.println(zll);
        String trj = userService.getName("trj");
        System.out.println(trj);
        String zb = userService.getName("zb");
        System.out.println(zb);
        System.out.println("按任意键退出");
        System.in.read(); // 按任意键退出
    }
}
