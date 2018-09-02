package ocp.chapter.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ComparableJav {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("alex"));
		students.add(new Student("julian"));
		students.add(new Student("brandon"));
		System.out.println(students); // [alex, julian, brandon]
		Collections.sort(students);
		System.out.println(students); // [alex, brandon, julian]
		
		List<Numbers> numbers = new ArrayList<>();
		numbers.add(new Numbers(1));
		numbers.add(new Numbers(-3));
		System.out.println(numbers); // [1, -3]
		System.out.println(numbers.get(0).compareTo(numbers.get(1))); // 4
		Collections.sort(numbers);
		System.out.println(numbers); // [-3, 1]
		
		
		Comparator<Student> byId = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getNumber() - o2.getNumber();
			}
		};
		
		Comparator<Student> byIdLambda = (s1, s2) -> { return s1.getNumber() - s2.getNumber(); };
		System.out.println(students);
		Collections.sort(students, byId); // [alex, brandon, julian]
		System.out.println(students); // [alex, julian, brandon]
		Collections.sort(students);
		System.out.println(students); // [alex, brandon, julian]
		Collections.sort(students, byIdLambda);
		System.out.println(students); // [alex, julian, brandon]

		students.get(0).setNote(70);
		students.get(1).setNote(30);
		Comparator<Student> byNote = StudentUtil::compareByNote;
		Collections.sort(students, byNote);
		System.out.println(students); // [brandon, julian, alex]
		Collections.shuffle(students);
		System.out.println(students); // [alex, julian, brandon]
		Comparator<Student> byNoteInstance = students.get(0)::compareByNote;
		Collections.sort(students, byNoteInstance);
		System.out.println(students); // [brandon, julian, alex]
		
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.removeIf(a -> a<2);
		System.out.println(list); // [2, 3]
		list.replaceAll(a -> a*3);
		System.out.println(list); // [6, 9]
		list.forEach(a -> System.out.print(a)); // 69
		list.forEach(System.out::println);// 6 9
		
		
		Map<String, String> map =  new HashMap<>();
		map.put("arctic monkeys", "alex turner");
		map.put("arctic monkeys", null);
		System.out.println(map); // {arctic monkeys=null}
		map.put("the strokes", "julian casablancas");
		map.putIfAbsent("arctic monkeys", "alex turner");
		map.putIfAbsent("the strokes", "brandon flowers");
		System.out.println(map); // {the strokes=julian casablancas, arctic monkeys=alex turner}
		
		map.put("the kooks", null);
		BiFunction<String, String, String> biFunc = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
		map.merge("the killers", "brandon flowers", biFunc);
		map.merge("arctic monkeys", "miles kane kane", biFunc);
		map.merge("the kooks", "should not be empty", biFunc);
		System.out.println(map); // {the killers=brandon flowers, the strokes=julian casablancas, arctic monkeys=miles kane kane}

	}

}

class StudentUtil {
	public static int compareByNote(Student s1, Student s2) {
		return s1.getNote() - s2.getNote();
	}
}
class Numbers implements Comparable<Numbers>{
	private int id;
	public Numbers(int id) {
		this.id = id;
	}
	@Override
	public int compareTo(Numbers o) {
		return id - o.id;
	}
	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
class Student implements Comparable<Student> {
	private int number;
	private String name;
	private int note;
	private static int counter = 0;
	
	public Student(String name) {
		this.name = name;
		this.number = counter;
		counter++;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}

	public int compareByNote(Student s1, Student s2) {
		return s1.getNote() - s2.getNote();
	}
}
