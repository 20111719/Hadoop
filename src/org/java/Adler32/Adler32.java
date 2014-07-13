package org.java.Adler32;
/**
 * 新的A = 原来的A - D1 + D(n+1) 
 * 新的B = 新的A + 原来的B - n * D1-1
 * @author jsj
 *
 */
public class Adler32{
	public static int set(byte[] data){
		int mod = 65521,
			a = 1,
			b = 0;
		for(int i = 0; i < data.length; i++){
			a = a + data[i];
			b = a + b;
		}
		a = a % mod;
		b = b % mod;
		
		return b * 65536 + a;
	}
	
	public static final int MOD = 65521;
	
	public static int adler32(byte[] datas){
		int A = 1;
		int B = 0;
		for(byte b:datas){
			A = A + b;
			B = B + A;
		}
		A = A % MOD;
		B = B % MOD;
		return B << 16 | A;
	}
	
	public static int newAdler32(int adler32, byte preByte, byte nextByte, int length){
		//1.找出原来的A和B
		int oldA = adler32 & 0xffff;
		int oldB = (adler32 >> 16) & 0xffff;
		//2.计算新的A和B
		int A = oldA - preByte + nextByte;
		int B = A + oldB - length * preByte - 1;
		//3.得到新的Adler32
		return (B % MOD) << 16 | (A%MOD);
	}
	
	public static String niYunSuan(int res){
		int A = 0;
		int B = 0;
		A = res & 0xffff;
		B = (res >> 16) & 0xffff;
		return A + " , " + B;
	}
}

