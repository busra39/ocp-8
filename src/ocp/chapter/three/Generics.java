package ocp.chapter.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Generics {

	public static void main(String[] args) {
		Thing var = new Thing();
		Gen<Integer, Thing> genThing = new Gen<>(1, var);
		
		Thing.<String>ship("aa"); // Test: aa
		Thing.ship("aa"); // Test: aa
		Thing.<Integer>ship(1); // Test: 1
		
		List<? extends Car> cars = new ArrayList<Car>();
		List<Audi> audis = Arrays.asList(new Audi(4), new Audi(5));
		print(audis); // 4 5
		print2(audis); // 4 5
		
		List<Car> carList = Arrays.asList(new Car(), new Car());
		print(carList); // 0 0
		print2(carList);  // 0 0
		
		List<? super B1> list = new ArrayList<A1>();
		//list.add(new A1()); // DOES NOT COMPILE
		list.add(new B1());
		list.add(new C1());
		
	}
	
	public static void print(List<? extends Car> cars) {
		for (Car car: cars)
		      System.out.println(car.getNum());
	}
	
	public static void print2(List<? extends Vehicle> cars) {
		for (Vehicle car: cars)
		      System.out.println(car.getNum());
	}

}

class A1 {}
class B1 extends A1 {}
class C1 extends B1 {}

interface Vehicle{
	public int getNum();
}
class Car implements Vehicle{
	public int getNum() { return 0;}
}
class Audi extends Car {
	private int num;
	public Audi(int a) {
		this.num = a;
	}
	public int getNum() {
		return num;
	}
}

interface GenInterface<T>{
	public abstract void get(T t);
}

class GenClass1 implements GenInterface<Thing>{
	@Override
	public void get(Thing t) {}	
}

class GenClass2<U> implements GenInterface<U>{
	@Override
	public void get(U t) {}	
}

class GenClass3 implements GenInterface{
	@Override
	public void get(Object t) {}	
}

class Gen<K,V>{
	private K key;
	private V value;
	
	public Gen(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class Thing {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public static <T> void ship(T t) {
		System.out.println("Test: " + t);
	}
}