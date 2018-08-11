package ocp.chapter.one;

public class VirtualMethods {
	public static void main(final String... args) {
      ParentClass parent = new ChildClass();
      ChildClass child = new ChildClass();
      SuperChildClass superChild = new SuperChildClass();
      parent.printName(); // abstract
      child.printName(); // abstract
      superChild.printName(); // child
	}
}

abstract class ParentClass {
   String name = "abstract";
   public void printName() {
      System.out.println(name);
   }
}

class ChildClass extends ParentClass {
   String name = "child";
}

class SuperChildClass extends ChildClass {
	public void printName() {
	      System.out.println(name);
	}
}