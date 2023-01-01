package 자바자료구조;

import java.util.Arrays;
import java.util.Collections;

public class 스트링배열정렬 {
	public static void main(String[] args) {
	String[] s = { "sort", "string", "array" };
//	Arrays.sort(s);
//	Arrays.sort(s, Comparator.naturalOrder());
//	Arrays.sort(s, Comparator.reverseOrder()); 
	
	/*
	Arrays.sort(s, new Comparator<String>() {
	    @Override
	    public int compare(String o1, String o2) {
	        return o2.compareTo(o1);            // 내림차순으로 정렬
	    }
	});
	*/
//	s = Arrays.stream(s).sorted().toArray(String[]::new);	
//	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
	Collections.sort(Arrays.asList(s));
	Fruit[] arr = {
	        new Fruit("Apple", 200),
	        new Fruit("Kiwi", 500),
	        new Fruit("Orange", 200),
	        new Fruit("Banana", 50),
	        new Fruit("Watermelon", 880),
	        new Fruit("Cherry", 10)
	};

	Arrays.sort(arr);

	System.out.println("Sorted arr[] : " + Arrays.toString(arr));
	System.out.println(Arrays.toString(s));        // [array, sort, string]
	}
}
