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
				byte b = datas[i]; // 取第 i 个字节
				str[k++] = hexDigits[b >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[b & 0xf]; // 取字节中低 4 位的数字转换
				s = new String(str); // 换后的结果转换为字符串
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
