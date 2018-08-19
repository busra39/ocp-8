package ocp.chapter.two;

public class EncapsulationJava {

	public static void main(String[] args) {

	}

}

class Person{
	private int id;
	private String name;
	
	public Person(int id, String name) {
		if(id >= 0 && name != null) {
			this.id = id;
			this.name = name;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}