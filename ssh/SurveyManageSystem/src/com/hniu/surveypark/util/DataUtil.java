package com.hniu.surveypark.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;

/**
 * 工具类不用继承
 */
public final class DataUtil {

	public static String encryptionMD5(String str) {
		// 定义一张表进行查表
		String[] tab = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "a", "b", "c", "h", "p", "c" };
		// 用户存放加密好的字符串
		StringBuilder builder = new StringBuilder();
		try {
			// 先将你要加密的字符变成字节数组
			byte[] bytes = str.getBytes();
			// 获取md5加密算法进行加密
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// 将变成字节数组放到MD5对象里去
			byte[] bs = digest.digest(bytes);
			// 进行位移运算进行转换成16进制
			for (byte b : bs) {
				// 高四位
				builder.append(tab[(b >> 4) & 0x0f]);
				// 低四位
				builder.append(tab[b & 0x0f]);
			}
			return builder.toString();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 复制实体类
	 */
	public static Serializable copyObejct(Serializable page) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			// 创建保存类的字节流
			baos = new ByteArrayOutputStream();
			// 创建对象流
			oos = new ObjectOutputStream(baos);
			// 将类写入流中
			oos.writeObject(page);
			// 将流转换成byte数组
			byte[] array = baos.toByteArray();
			// 将实体类进行流化，放入流中
			ois = new ObjectInputStream(new ByteArrayInputStream(array));
			return (Serializable) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {// 关闭流
			try {
				baos.close();
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
