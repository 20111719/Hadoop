package MD5;
import input.InputUtil;
public class TestMD5 {
	public static void main(String[] args){
		System.out.println("input:");
		String str = InputUtil.readString();
		byte datas[] = new byte[100];
		
		datas = str.getBytes();
		
		System.out.println(MD5.getMD5(datas));
	}
}
