package ocp.chapter.two;

public class FunctInterface {

	public static void main(String[] args) {
		Machine.print(new Machine(true), a -> a.isAuto()); // true
		Machine.print(new Machine(true), (a) -> a.isAuto());
		Machine.print(new Machine(true), (Machine a) -> a.isAuto());
		//Machine.print(new Machine(true), Machine a -> a.isAuto()); // NO
		//Machine.print(new Machine(true), a -> {a.isAuto()}); // NO
		Machine.print(new Machine(true), a -> {return a.isAuto();}); 
		//Machine.print(new Machine(true), a -> return a.isAuto()); // NO
		//Machine.print(new Machine(true), a -> return a.isAuto();); // NO
		Machine.print(new Machine(true), (a) -> {return a.isAuto();}); 
		//Machine.print(new Machine(true), a -> int b=9; a->a.isAuto()); // NO
		Machine.print(new Machine(true), a -> {int b=0; return a.isAuto();}); 
		Machine.print2(new Machine(true), () -> new Machine(false)); // false
		//Machine.print(new Machine(true), a -> {Machine a=null; return a.isAuto();}); // NO
		Machine.print3(new Machine(true), (Machine m, boolean a) -> m.isAuto() );
		//Machine.print3(new Machine(true),  m, a -> m.isAuto() ); // NO
		//Machine.print3(new Machine(true),  (Machine m, a) -> m.isAuto() ); // NO
		Machine.print4(new Machine(true), () -> {} );
		Machine.print4(new Machine(true), () -> {return;} );
	}


}

/*
 * DEFINING FUNCTIONAL INTERFACE
 */
@FunctionalInterface
interface Drive {
   public void sprint(Car car);
   /*
    * DOES NOT COMPILE
    */
   //public void sprint2(Car car);
}

@FunctionalInterface
interface AutoDrive extends Drive{
}

@FunctionalInterface
interface ManualDrive extends Drive{
	public void sprint(Car car);
}

@FunctionalInterface
interface HalfAutoDrive extends Drive{
	public default void print() {
		System.out.println("default");
	}
	public static void get() {
		System.out.println("get");
	}
}
 
class Car implements Drive {
   public void sprint(Car car) {
      System.out.println("Car");
   }
}

/*
 * IMPLEMENTING FUNCTIONAL INTERFACE
 */
interface Checking {
	public boolean test(Machine machine);
}

interface Checking2 {
	public Machine test();
}

interface Checking3 {
	public boolean test(Machine machine, boolean check);
}

interface Checking4 {
	public void test();
}

class Machine{
	public boolean isAuto = true;
	
	public Machine(boolean isAuto) {
		this.isAuto = isAuto;
	}

	public boolean isAuto() {
		return isAuto;
	}
	
   public static void print(Machine machine, Checking check) {
      if(check.test(machine))
         System.out.println(machine.isAuto());
   }
   
   public static void print2(Machine machine, Checking2 check) {
	   System.out.println(check.test().isAuto);
   }
   
   public static void print3(Machine machine, Checking3 check) {
	   System.out.println(check.test(machine, false));
   }
   
   public static void print4(Machine machine, Checking4 check) {
	   check.test();
   }
   
	
}