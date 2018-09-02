package ocp.chapter.three;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapsJava {
	public static void main(String...strings) {
		HashMap<String, String> hashMap =  new HashMap<>();
		LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();
		TreeMap<String, String> treeMap =  new TreeMap<>();
		
		hashMap.put("aa", "arctic monkeys");
		hashMap.put("cc", "the strokes");
		hashMap.put("bb", "the killers");
		System.out.println(hashMap); // {aa=arctic monkeys, cc=the strokes, bb=the killers}
		System.out.println(hashMap.get("cc")); // the strokes
		
		hashMap.put("dd", null);
		for(String ss : hashMap.keySet()) {
			System.out.print(ss + " " ); //aa cc bb dd
		}
		
		
		hashMap.values();
		
		linkedMap.put("aa", "alex");
		linkedMap.put("cc", "julian");
		linkedMap.put("bb", "brandon");
		System.out.println(linkedMap); // {aa=alex, cc=julian, bb=brandon}

		treeMap.put("dd", null);
		for(String ss : linkedMap.keySet()) {
			System.out.print(ss + " " ); //aa cc bb dd
		}

		treeMap.put("aa", "arctic monkeys");
		treeMap.put("cc", "the strokes");
		treeMap.put("bb", "the killers");
		System.out.println(treeMap); // {aa=arctic monkeys, bb=the killers, cc=the strokes}
		

		for(String ss : treeMap.keySet()) {
			System.out.print(ss + " " ); //aa bb cc
		}
	}

}
