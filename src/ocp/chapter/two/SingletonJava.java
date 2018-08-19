package ocp.chapter.two;

public class SingletonJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class One {
	private static final One instance = new One();
	
	private One() {}
	
	public static One getInstance() {
		return instance;
	}
}

class Two {
	private static final Two instance;
	static{
		instance = new Two();
	}
	
	private Two() {}
	
	public static Two getInstance() {
		return instance;
	}
}

class Three {
	private static Three instance;
	
	private Three() {}
	
	public static Three getInstance() {
		if(instance == null)
			instance = new Three();
		return instance;
	}
}

class Four {
	private static Four instance;
	
	private Four() {}
	
	public static Four getInstance() {
		if(instance == null) {
			synchronized(Four.class) {
				if(instance == null) {
					instance = new Four();
				}
			}
		}
		return instance;
	}
}