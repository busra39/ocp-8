package ocp.chapter.one;

public class InstanceOf {
	
	public static void main (String... args) {
		
		Animal animal = new Bat();
		System.out.println((animal instanceof Bat)); // true
		System.out.println((animal instanceof Eagle)); // false
		System.out.println((animal instanceof LiveOnAir)); // true
		System.out.println((animal instanceof LiveOnLand)); // false
		System.out.println((animal instanceof Animal)); // true
		
		LiveOnAir flyingAnimal = new Eagle();
		System.out.println((flyingAnimal instanceof Bat)); // false
		System.out.println((flyingAnimal instanceof Eagle)); // true
		System.out.println((flyingAnimal instanceof LiveOnAir)); // true
		//System.out.println((flyingAnimal instanceof LiveOnLand)); // COULD NOT COMPILE
		System.out.println((flyingAnimal instanceof Animal)); // true

		Snail snail = new Snail();
		System.out.println((snail instanceof Snail)); // true 
		//System.out.println((snail instanceof LiveOnAir)); // COULD NOT COMPILE
		System.out.println((snail instanceof LiveOnLand)); // true
		System.out.println((snail instanceof Animal)); // true
		
		Animal animal2 = new LiveOnAir();
		System.out.println((animal2 instanceof Bat)); // false
		System.out.println((animal2 instanceof Eagle)); // false
		System.out.println((animal2 instanceof Snail)); // false
		System.out.println((animal2 instanceof LiveOnAir)); // true
		System.out.println((animal2 instanceof LiveOnLand)); // false
		System.out.println((animal2 instanceof Animal)); // true
		
		LiveOnLand liveOnLand = new LiveOnLand();
		System.out.println((liveOnLand instanceof Snail)); // false
		System.out.println((liveOnLand instanceof Animal)); // true
		
		
		System.out.println((animal instanceof Object)); // true

		System.out.println((flyingAnimal instanceof Object)); // true

		System.out.println((snail instanceof Object)); // true
		
		//System.out.println(snail instanceof Integer); // COULD NOT COMPILE
		
		snail = null;
		System.out.println((snail instanceof Object)); // false
		//System.out.println((animal instanceof null)); // COULD NOT COMPILE
		System.out.println(null instanceof Void); // false
		
		System.out.println(new Sheep[0] instanceof Sheep[]); // true	
		
		System.out.println(animal instanceof Car); // false
		System.out.println(animal2 instanceof Car); // false
		System.out.println(flyingAnimal instanceof Car); //false
		
		Animal callAnimal = new Animal();
		call(callAnimal); // empty
		
		Animal callLiveOnAir = new LiveOnAir();
		call(callLiveOnAir); // LiveOnAir.fly
		
		Animal callLiveOnLand = new LiveOnLand();
		call(callLiveOnLand); // empty

		Animal callBat = new Bat();
		call(callBat); // LiveOnAir.fly & Bat.hang
		
		Animal callEagle = new Eagle();
		call(callEagle); // LiveOnAir.fly & Eagle.hunt
		
		LiveOnAir callBat2 = new Bat();
		call(callBat2); // LiveOnAir.fly & Bat.hang
		
		Bat callBat3 = new Bat();
		call(callBat3); // LiveOnAir.fly & Bat.hang
	}
	
	public static void call(Animal animal) {
		if(animal instanceof LiveOnAir)
			System.out.println(((LiveOnAir)animal).fly());
		if(animal instanceof Bat)
			System.out.println(((Bat)animal).hang());
		if(animal instanceof Eagle)
			System.out.println(((Eagle)animal).hunt());
	}
}

interface Car {}

class Animal {
	
}

class LiveOnAir extends Animal{
	public String fly() { return "LiveOnAir.fly"; }
}

class Bat extends LiveOnAir {
	public String hang() { return "Bat.hang"; }
}

class Eagle extends LiveOnAir {
	public String hunt() { return "Eagle.hunt";}
}

class LiveOnLand extends Animal{
	
}

class Snail extends LiveOnLand {
	
}

class Sheep extends LiveOnLand {
	
}

