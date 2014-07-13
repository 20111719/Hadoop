package org.java.Adler32;

import java.io.UnsupportedEncodingException;
import input.InputUtil;
public class TestAlder32 {
	public static void main(String[] args){
		System.out.println("please niput a String:");
		byte[] data = new byte[100];
		String str = InputUtil.readString();
		
		try {
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int result = Adler32.adler32(data);
		System.out.println("Result: " + result);
		
		System.out.println(Adler32.niYunSuan(300286872));
	}
}
