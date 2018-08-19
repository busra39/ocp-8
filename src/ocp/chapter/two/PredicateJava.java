package ocp.chapter.two;

import java.util.function.Predicate;

public class PredicateJava {

	public static void main(String[] args) {
		Television.print(new Television(true), (a) -> a.isAuto()); // true
		Television.print(new Television(false), (a) -> a.isAuto()); // nothing
	}

}
class Television{
	public boolean isAuto = true;
	
	public Television(boolean isAuto) {
		this.isAuto = isAuto;
	}

	public boolean isAuto() {
		return isAuto;
	}
	
   public static void print(Television machine, Predicate<Television> check) {
      if(check.test(machine))
         System.out.println(machine.isAuto());
   }
}