package ocp.chapter.two;

public class InterfaceJava {

	public static void main(String[] args) {
		DummyImpl impl = new DummyImpl();
		impl.fly(); // DummyImpl.fly
		impl.print(); // DummyImpl.default
		impl.method(); // DummyImpl.static
		DummyImpl.method(); // DummyImpl.static
		System.out.println(DummyInterface.number + " " + DummyInterface.var); // 2 4
		DummyInterface interf = impl;
		interf.fly(); // DummyImpl.fly
		interf.print(); // DummyImpl.default
		DummyInterface.method(); // static
		//interf.method(); // DOES NOT COMPILE
		System.out.println(interf.number + " " + interf.var); // 2 4

	}

}

interface DummyInterface {
	public int number = 2;
	static final int var = 4; 
	
	/*
	 * All methods and variables are public by default
	 */
	void fly();
	
	default void print() {
		System.out.println(" default");
	}
	
	public static void method() {
		System.out.println("static");
	}
}

class DummyImpl implements DummyInterface {

	@Override
	public void fly() {
		System.out.println("DummyImpl.fly");
	}
	
	/*
	 * if it is not public DOES NOT COMPILE
	 * Because the default method of Interface is public by default.
	 * Modifier type can not be narrower.
	 */
	public void print() { 
		System.out.println("DummyImpl.default");
	}
	
	public static void method() {
		System.out.println("DummyImpl.static");
	}
	
}
