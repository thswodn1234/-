package 자바자료구조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
public class Chap1_ArrayString {
	public static String[] removeElement1(String[] arr, String item) {
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		list.remove(item);
		return list.toArray(String[]::new);
	}
	public static void main(String[] args) {
		
//		String a = "hello" , b = "good";
//		String tmp = a;
//		a = b ; 
//		b = tmp;
//		System.out.println(a);
//		System.out.println(b);
		
		ArrayList<String> list = new ArrayList<String>(); // ArrayList 생성
		
		System.out.println("list는 " + list.getClass().getSimpleName() + "\n");

		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");

		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");

		list.add(1, "LA");

		String[] array = list.toArray(new String[list.size()]); // ArrayList => 배열
		System.out.println("array는 " + array.getClass().getSimpleName() + "\n");
		
		
		// 배열 정렬
		for(int k=0 ; k < array.length ; k++) {
			for(int i= k + 1 ; i < array.length - 1 ; i++) {
				if(array[k].compareTo(array[i]) > 0){
					String tmp = array[k];
					array[k] = array[i];
					array[i] = tmp;
				} 
				
			}
			
		}
								
		
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array)); // 배열 => ArrayList
																				
		// arrayList에서 중복 원소 제거
		
		for(int i = 0; i < arrayList.size(); i++) {
			if(Collections.frequency(arrayList, arrayList.get(i)) > 1) {
				while(Collections.frequency(arrayList, arrayList.get(i)) != 1) {
				arrayList.remove(i);
				}
			}
		}
		
		System.out.println("arrayList는 " + arrayList.getClass().getSimpleName() + "\n");

		
		System.out.println("정렬된 arrayList 출력: ");
		for ( String city: arrayList) 
	    	System.out.println(city);
	
	}
	
	
}
