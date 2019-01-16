package 异常;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 此类是：异常，异常分为两大类，一个是Error,一个是Exception Error:是不可挽回的异常，一旦发生程序直接停止运行，如
 * OutOfMemoryError Exception: 异常可捕捉可处理，如
 * NullPointerException,IndexOutOfBoundsException 
 * 1 检查异常
 * 2 非检查异常（RuntimeException）
 * 
 * @author hpc
 * @date 2016年12月9日 下午9:02:23
 */
public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SbException {

		try {
			new FileInputStream(new File(""));
		} catch (Exception e) {
			throw  new SbException("找你个头，我给你一个空串你找一下看看");
		}

	}
}

/**
 * 此类是：异常类
 * 
 * @author hpc
 * @date 2016年12月9日 下午9:21:52
 */
class SbException extends Exception {

	private static final long serialVersionUID = -6137866848733412750L;

	public SbException() {
		super();
	}

	public SbException(String m) {
		super(m);
	}

}