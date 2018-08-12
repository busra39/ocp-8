package ocp.chapter.one;

import ocp.chapter.one.OuterMember.InnerMember;
import ocp.chapter.one.OuterStatic.NestedStatic;

public class NestedJava {

	public static void main(String[] args) {
		
		/*
		 * Member Inner Class
		 */
		OuterMember outer = new OuterMember();
	    outer.callInner(); // Outer 5 8 9
	    System.out.println(outer.num); // 5
	    
	    InnerMember inner = outer.new InnerMember();
	    inner.print(); // Outer 5 8 9
	    OuterMember.InnerMember.Deeper deep = inner.new Deeper(); // declaring another inner class.
	    
	    /*
	     * Local Inner Class
	     */
	    OuterLocal outerLocal = new OuterLocal();
	    outerLocal.print(); // 9
	    
	    /* 
	     * Anonymous Inner Class
	     */
	    OuterAnon outerAnon = new OuterAnon();
	    outerAnon.start(); // In the start.fly
	    outerAnon.stop(); // In the stop.walk 4
	    
	    /*
	     * Static Nested Class
	     */
	    NestedStatic nested = new NestedStatic();
	    System.out.println(nested.getName()); // 9 Nested
	}

}

/*
 * Member Inner Class
 */
class OuterMember {
   private String name = "Outer";
   public static int num = 3;
   public int n = 9;

   // can be public, default, private / same level as methods
   protected class InnerMember extends NestedDummy implements NestedDummyInterface{ 
	   public int n = 8;
      public void print() {
         System.out.print(name); // access member of outer class
         num = 5;
         System.out.print(num); 
         System.out.print(n);
         System.out.println(OuterMember.this.n);
      }
      protected class Deeper {
    	  
      }
   }

   public void callInner() {
      new InnerMember().print();
   }
}

interface NestedDummyInterface {}

class NestedDummy {}

/*
 * Local Inner Class
 */
class OuterLocal{
	private int number = 4;
	public void print() {
		int sum = 5;
		int tmp; // will not break the code. effectively final
		//sum =8; -> reassigning breaks final rule of variables. So the code gives error on print line.
		if(true)
			tmp = 9;
		else
			System.out.println("no");
		/*
		 * Declared in method level
		 * Do not have access modifier / otherwise COULD NOT COMPILE
		 */
		class InnerLocal extends NestedDummy implements NestedDummyInterface{
			public void printAll() {
				System.out.println(number + sum + tmp); /// access outer class's and methods & fields
			}
		}
		//sum = 9; -> this is also caused error on print line.
		InnerLocal inmem = new InnerLocal();
		inmem.printAll();
	}
}

/*
 * Anonymous Inner Class
 */
class OuterAnon{
	abstract class InnerAbstract{
		abstract void fly();
	}
	public void start() {
		/*
		 * Inner abstract classes can be invoked. You have to provide method body
		 */
		InnerAbstract abs = new InnerAbstract() {
			
			@Override
			void fly() {
				System.out.println("In the start.fly");
				
			}
		};
		abs.fly(); 
	}
	
	interface InnerInterface{
		abstract int walk();
	}
	
	public void stop() {

		get(new InnerInterface() {
			
			@Override
			public int walk() {
				System.out.println("In the stop.walk");
				return 4;
			}
		});
	}
	
	public void get(InnerInterface in) {
		System.out.println(in.walk());
	}
}

/*
 * Static Nested Class
 */
class OuterStatic {
	public static int n = 9;
	/*
	 * Member level
	 * access outer class's static variables.
	 */
	static class NestedStatic{
		private String name = "Nested";
		public String getName() {
			System.out.println(n);
			return name;
		}
	}
}