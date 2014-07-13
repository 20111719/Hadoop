package MD5;

import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String getMD5(byte[] source){
		String s = null;
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D','E', 'F' };
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			
			byte datas[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) { 
				byte b = datas[i]; // ȡ�� i ���ֽ�
				str[k++] = hexDigits[b >>> 4 & 0xf]; // ȡ�ֽ��и� 4 λ������ת��, >>> Ϊ�߼����ƣ�������λһ������
				str[k++] = hexDigits[b & 0xf]; // ȡ�ֽ��е� 4 λ������ת��
				s = new String(str); // ����Ľ��ת��Ϊ�ַ���
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
