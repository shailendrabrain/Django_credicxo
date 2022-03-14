package template;
import java.util.Scanner;
public class ScannerFactory {

	static Scanner sc=null;
	private ScannerFactory()
	{
		
	}
	
	public static synchronized Scanner getScanner()
	{
		if(sc==null)
		{
			sc=new Scanner(System.in);
		}
		return sc;
	}
	
}
