package ocp.chapter.three;

import java.util.ArrayList;
import java.util.List;

public class Boxing {
	public static void main(String...strings) {
		Test1.func(1); // long
		Test1.func(1L); // long
		Test1.func(new Long(3)); // Long
		
		Test2.func(1); // Object
		//Test3.func(1); // DOES NOT COMPILE
		
		Test4.func(1); // long
		Test5.func(1); // Integer
		
		Test6.func(1); // long
		Test7.func(1); // Object
		Test8.func(1); // Integer
		//Test9.func(1); // DOES NOT COMPILE
		Test10.func(1); // Object
		Test11.func(1); // Integer...
		Test12.func(1); // int...
		
		ParentBoxing parent = new ChildBoxing();
		parent.func(1); // Parent int
		ChildBoxing child = new ChildBoxing();
		child.func(1); // Parent int
		
		List<Integer> list = new ArrayList();
		list.add(1); // AutoBoxing
		Integer num = 3; // AutoBoxing
		
		Integer number = new Integer(3);
		int i = convert(number); // unboxing
		int tmp = list.get(0); // unboxing
		
		number.intValue(); // returns int
		number.parseInt("22");
	}

	 public static int convert(int i) {
	        return (i < 0) ? -i : i;
	 }
}

class ParentBoxing{
	public void func(int a) {
		System.out.println("Parent int");
	}
}

class ChildBoxing extends ParentBoxing {
	public void func(Integer a) {
		System.out.println("Child Integer");
	}
}

class Test1 {
	public static void func(long a) {
		System.out.println("long");
	}
	
	public static void func(Long a) {
		System.out.println("Long");
	}

	public static void func(Object a) {
		System.out.println("Object");
	}
}

class Test2 {
	public static void func(Long a) {
		System.out.println("Long");
	}

	public static void func(Object a) {
		System.out.println("Object");
	}
}

class Test3 {
	public static void func(Long a) {
		System.out.println("Long");
	}
}

class Test4 {
	public static void func(Integer a) {
		System.out.println("Integer");
	}
	
	public static void func(long a) {
		System.out.println("long");
	}
	
	public static void func(Long a) {
		System.out.println("Long");
	}

	public static void func(Object a) {
		System.out.println("Object");
	}
}

class Test5 {
	public static void func(Integer a) {
		System.out.println("Integer");
	}
	
	public static void func(Long a) {
		System.out.println("Long");
	}

	public static void func(Object a) {
		System.out.println("Object");
	}
}

class Test6 {
 	public static void func(long a) {
		System.out.println("long");
	}

	public static void func(Object a) {
		System.out.println("Object");
	}
	
	public static void func(int... a) {
		System.out.println("int...");
	}
}

class Test7 {
	public static void func(Object a) {
		System.out.println("Object");
	}
	
	public static void func(int... a) {
		System.out.println("int...");
	}
}

class Test8 {
	public static void func(Integer a) {
		System.out.println("Integer");
	}
	
	public static void func(int... a) {
		System.out.println("int...");
	}
}

class Test9 {
	public static void func(int... a) {
		System.out.println("int...");
	}

	public static void func(Integer...integers) {
		System.out.println("Integer...");
	}
}

class Test10 {
	public static void func(Object a) {
		System.out.println("Object");
	}

	public static void func(Integer...integers) {
		System.out.println("Integer...");
	}
}

class Test11 {
	public static void func(Long a) {
		System.out.println("Long");
	}

	public static void func(Integer...integers) {
		System.out.println("Integer...");
	}
}

class Test12 {
	public static void func(Long a) {
		System.out.println("Long");
	}

	public static void func(int...integers) {
		System.out.println("int...");
	}
}
