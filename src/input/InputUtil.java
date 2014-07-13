package input;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputUtil {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//read string
	public static String readString()
	{
		String result = "";
		try
		{
			result = br.readLine();
		}
		catch(Exception e)
		{
			//System.out.printle(e);
		}
		return result;
	}
	
	//read int
	public static int readInt()
	{
		int result = 0;
		try
		{
			result = Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			//System.out.printle(e);
		}
		return result;
	}
	//read double
	public static double readDouble()
	{
		double result = 0.0;
		try
		{
			result = Double.parseDouble(br.readLine());
		}
		catch(Exception e)
		{
			//System.out.printle(e);
		}
		return result;
	}
}
