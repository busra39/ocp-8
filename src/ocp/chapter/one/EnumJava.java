package ocp.chapter.one;

public class EnumJava {

	public static void main(String... str) {
		Days monday = Days.MONDAY;
		System.out.println(monday); // MONDAY
		System.out.println(monday == Days.MONDAY); // true
		
		for(Days day: Days.values()) {
			System.out.println(day.name() + " " + day.ordinal());
		}
		
		Days d1 = Days.valueOf("SUNDAY");
		System.out.println(d1); // SUNDAY
		//d1 = Days.valueOf("sunday");
		//System.out.println(d1.name()); //  throws IllegalArgumentException
		
		switch(d1) {
			case TUESDAY:
				System.out.println(Days.TUESDAY);
				break;
			case FRIDAY:
				//System.out.println(FRIDAY); // DOES NOT COMPILE
				break;
			//case Days.FRIDAY: DOES NOT COMPILE
			//case 4: DOES NOT COMPILE
			default:
				System.out.println(Days.SUNDAY);
		}
		
		for (Size e: Size.values()) {
		    System.out.println(e.toString() + " " + e.size);
		}
		
		Size.LARGE.print(Size.SMALL); // 36
		Size.MEDIUM.call(); // 38
	}
}

enum Days {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Size {
	MEDIUM(38), SMALL(36), LARGE(40), XLARGE(42); // provide constructor to compile
	int size;
    private Size(int size) {
        this.size = size;
        System.out.println("called"); // called only 4 times. 
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
    
    public void print(Size s) {
    	System.out.println(s.size);
    }
    
    public void call() {
    	System.out.println(size);
    }
}

enum Tracian {
	EDIRNE {
		public void print() { System.out.println("edirne"); }
	}, KIRKLARELI {
		public void print() { System.out.println("kirklareli"); }
	}, TEKIRDAG {
		public void print() { System.out.println("tekirdag"); }
	};
	public abstract void print();
}