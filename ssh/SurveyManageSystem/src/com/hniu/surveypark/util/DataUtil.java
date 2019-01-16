package com.hniu.surveypark.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;

/**
 * �����಻�ü̳�
 */
public final class DataUtil {

	public static String encryptionMD5(String str) {
		// ����һ�ű���в��
		String[] tab = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "a", "b", "c", "h", "p", "c" };
		// �û���ż��ܺõ��ַ���
		StringBuilder builder = new StringBuilder();
		try {
			// �Ƚ���Ҫ���ܵ��ַ�����ֽ�����
			byte[] bytes = str.getBytes();
			// ��ȡmd5�����㷨���м���
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// ������ֽ�����ŵ�MD5������ȥ
			byte[] bs = digest.digest(bytes);
			// ����λ���������ת����16����
			for (byte b : bs) {
				// ����λ
				builder.append(tab[(b >> 4) & 0x0f]);
				// ����λ
				builder.append(tab[b & 0x0f]);
			}
			return builder.toString();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * ����ʵ����
	 */
	public static Serializable copyObejct(Serializable page) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			// ������������ֽ���
			baos = new ByteArrayOutputStream();
			// ����������
			oos = new ObjectOutputStream(baos);
			// ����д������
			oos.writeObject(page);
			// ����ת����byte����
			byte[] array = baos.toByteArray();
			// ��ʵ���������������������
			ois = new ObjectInputStream(new ByteArrayInputStream(array));
			return (Serializable) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {// �ر���
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
