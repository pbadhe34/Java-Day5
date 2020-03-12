package app;

public class BaseClass {

	public int baseInt;
	
	private static void method3(){
		System.out.println("The private Method3");
	}
	
	private double updateMethod(Object obj){
		System.out.println("The private mewthod updateMethod  "+obj);
		return 876.54;
	}
	
	public int method4(){
		System.out.println("The public int Method4");
		return 0;
	}
	
	public static int method5(){
		System.out.println("The public static Method5");
		return 0;
	}
	
	void method6(){
		System.out.println("The derfault void Method6");
	}
	
	// inner public class
	public class BaseClassInnerClass{}
		
	//member public enum
	public enum BaseClassMemberEnum{}
}
