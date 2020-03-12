package app;


public class ConcreteClass extends BaseClass implements BaseInterface {

	public int publicInt;
	
	private String privateString="private string";
	
	protected boolean protectedBoolean;
	
	Object defaultObject;
	
	public ConcreteClass(int i){
		this.publicInt=i;
	}
	
	public ConcreteClass(){
		this.publicInt=0;
	}

	@Override
	public void method1() {
		System.out.println("Method1 impl on Concrete calss.");
	}

	@Override
	public int method2(String str) {
		System.out.println("Method2 impl.");
		return str.length() + 10;
	}
	
	@Override
	public int method4(){
		System.out.println("Method4 overriden.");
		return 0;
	}
	
	public int method5(int i){
		System.out.println("Method4 overriden.");
		return 0;
	}
	
	// inner classes
	public class ConcreteClassPublicClass{}
	private class ConcreteClassPrivateClass{}
	protected class ConcreteClassProtectedClass{}
	class ConcreteClassDefaultClass{}
	
	//member enum
	enum ConcreteClassDefaultEnum{}
	public enum ConcreteClassPublicEnum{}
	
	//member interface
	public interface ConcreteClassPublicInterface{}

}
