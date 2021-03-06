package ocp.chapter.three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class CollectionsJava {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		System.out.println(list.add("list1")); // true
		System.out.println(list.add("list1")); // true
		System.out.println(set.add("set1")); // true
		System.out.println(set.add("set1")); // false
		System.out.println(q.add("q1")); //true
		System.out.println(q.add("q1")); // true
		
		list.add("list2");
		System.out.println(list.remove("list2")); // true
		System.out.println(list.remove("empty")); // false
		list.add("list3");
		list.add("list4");
		list.add("list3");
		System.out.println(list.toString()); // [list1, list1, list3, list4, list3]
		list.remove("list3");
		System.out.println(list.toString()); // [list1, list1, list4, list3]
		
		set.add("set2");
		System.out.println(set.remove("set2")); // true
		System.out.println(set.remove("empty")); // false
		System.out.println(set.toString()); // set1
		
		q.add("q2");
		System.out.println(q.remove("q2")); // true
		System.out.println(q.remove("empty")); // false
		System.out.println(q.toString()); // [q1, q1]
		q.add("q3");
		q.add("q4");
		q.add("q3");
		System.out.println(q); // [q1, q1, q3, q4, q3]
		System.out.println(q.remove("q3")); // true
		
		System.out.println(list.isEmpty()); // false
		System.out.println(list.size()); // 3
		System.out.println(set.isEmpty()); // false
		System.out.println(set.size()); // 2
		System.out.println(q.isEmpty()); // false
		System.out.println(q.size()); // 4
		
		list.clear();
		System.out.println(list.isEmpty()); // true
		set.clear();
		System.out.println(set.isEmpty()); // true
		q.clear();
		System.out.println(q.size()); // 0
		
		list.add("list");
		System.out.println(list.contains("list")); // true
		System.out.println(list.contains("set")); // false
		set.add("set");
		System.out.println(set.contains("set")); // true
		System.out.println(set.contains("q")); // false
		q.add("q");
		System.out.println(q.contains("q")); // true
		System.out.println(q.contains("list")); // false

		
		list.clear();
		list.add("audi");
		list.add(1, "mercedes");
		list.add(2, "bmw");
		//ist.add(5, "fiat"); // IndexOutOfBoundsException
		System.out.println(list); // [audi, mercedes, bmw]
		list.add(2, "hyundai");
		System.out.println(list); // [audi, mercedes, hyundai, bmw]
		System.out.println(list.get(2)); // hyundai
		list.add("bmw");
		System.out.println(list.indexOf("bmw")); // 3
		System.out.println(list.indexOf(2)); // -1 @warning
		System.out.println(list.indexOf("honda")); // -1
		System.out.println(list.lastIndexOf("bmw")); // 4
		System.out.println(list.lastIndexOf(3)); // -1 @warning
		System.out.println(list.lastIndexOf("happy")); // -1
		System.out.println(list.set(1, "airbus")); // mercedes
		System.out.println(list); // [audi, airbus, hyundai, bmw, bmw]
		
		set.clear();
		set.add("10");
		set.add("20");
		set.add("11");
		set.add("12");
		set.add("22");
		System.out.println(set); // [11, 22, 12, 20, 10]
		set.add(null);
		
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("10");
		treeSet.add("20");
		treeSet.add("11");
		treeSet.add("12");
		treeSet.add("22");
		System.out.println(treeSet); // [10, 11, 12, 20, 22]
		// treeSet.add(null); //NullPointerException
		
		NavigableSet<String> navSet = new TreeSet<>();
		navSet.add("10");
		navSet.add("20");
		navSet.add("11");
		navSet.add("12");
		navSet.add("22");
		System.out.println(navSet); // [10, 11, 12, 20, 22]
		
		System.out.println(navSet.lower("12")); // 11
		System.out.println(navSet.floor("12")); // 12
		System.out.println(navSet.ceiling("12")); // 12
		System.out.println(navSet.higher("12")); // 20
		System.out.println(navSet.higher("22")); // null
		
		Stack<String> stack = new Stack<>();
		System.out.println(stack.add("apple")); // true
		System.out.println(stack.push("lemon")); // lemon
		System.out.println(stack); // [Apple, lemon]
		System.out.println(stack.elementAt(1)); // lemon
		System.out.println(stack.peek()); //lemon
		System.out.println(stack.pop()); // lemon
		System.out.println(stack.pop()); // apple
		System.out.println(stack.empty()); // true
		
		q.clear();
		System.out.println(q.add("red")); // true
		System.out.println(q.add("green")); // true
		System.out.println(q.peek()); // red
		System.out.println(q.element()); // red
		System.out.println(q.poll()); // red
		System.out.println(q.poll()); // green
		System.out.println(q.size()); // 0
		System.out.println(q.peek()); // null
		System.out.println(q.poll()); // null
		//System.out.println(q.element()); // NoSuchElementException
		System.out.println(q.offer("red")); // true
		System.out.println(q); // [red]
		System.out.println(q.remove("blue")); // false
		System.out.println(q.remove("red")); // true
		System.out.println(q.remove("ss")); // false
		
		ArrayDeque<String> deque = new ArrayDeque<>();
		System.out.println(deque.add("chair")); // true
		deque.push("table");
		System.out.println(deque); // [table, chair]
		deque.push("mirror");
		System.out.println(deque); // [mirror, table, chair]
		System.out.println(deque.peek()); // mirror
		System.out.println(deque.peekFirst()); // mirror
		System.out.println(deque.peekLast()); // chair
		System.out.println(deque.pop()); // mirror
		System.out.println(deque); // [table, chair]
		System.out.println(deque.poll()); // table
		System.out.println(deque); // [chair]
		deque.push("bed");
		deque.add("tv");
		System.out.println(deque); // [bed, chair, tv]
		System.out.println(deque.pollFirst()); // bed
		System.out.println(deque.pollLast()); // tv
		System.out.println(deque); // [chair]
		deque.add("fridge");
		System.out.println(deque); // [chair, fridge]
		System.out.println(deque.remove()); // chair
		System.out.println(deque); // [fridge]
		System.out.println(deque.offer("empty"));
		System.out.println(deque); // [fridge, empty]
		deque.clear();
		System.out.println(deque.peek()); // null
		System.out.println(deque.poll()); // null
		System.out.println(deque.pollFirst()); // null
		System.out.println(deque.pollLast()); // null
		System.out.println(deque.peekFirst()); // null
		System.out.println(deque.peekLast()); // null
		// deque.add(null); // NullPointerException
	}

}
