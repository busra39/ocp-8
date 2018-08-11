package ocp.chapter.one;

public class EqualsJava {
	public static void main (String... args) {
		
		String str = new String("abc");
		String str2 = new String("abc");
		System.out.println(str == str2); // false
		System.out.println(str.equals(str2)); // true
		
		Dummy d1 = new Dummy(1);
		Dummy d2 = new Dummy(1);
		System.out.println(d1 == d2); // false
		System.out.println(d1.equals(d2)); // false - Dummy does not override equals, uses Object's
		
		StringBuilder sb1 = new StringBuilder("aa");
		StringBuilder sb2 = new StringBuilder("aa");
		System.out.println(sb1.equals(sb2)); // false - StringBuilder does not override equals, uses Object's
		
		OverriddedEquality overriddedEquality =  new OverriddedEquality(1);
		OverriddedEquality overriddedEquality2 =  new OverriddedEquality(1);
		System.out.println(overriddedEquality.equals(overriddedEquality2)); // true;
		
	}

}

class Dummy {
	int n;
	public Dummy (int n) {
		this.n= n;
	}
	/*
	@Override 
	public boolean equals(Dummy obj) { // DOES NOT COMPILE - this is not overriding equals of Object
		if(!(obj instanceof Dummy))    // But it works.
			return false;
		Dummy tmp = (Dummy) obj;
		return tmp.n == this.n;
	}
	*/
}

class OverriddedEquality {
	int n;
	public OverriddedEquality (int n) {
		this.n= n;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof OverriddedEquality))
			return false;
		OverriddedEquality tmp = (OverriddedEquality) obj;
		return tmp.n == this.n;
	}
	
}
