package 자바자료구조;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Chap3_ObjectArraySort {
	public static void main(String[] args) {
//	String[] s = { "sort", "string", "array" };
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
//	Collections.sort(Arrays.asList(s));
	Fruit[] arr = {
	        new Fruit("사과", 200),
	        new Fruit("키위", 500),
	        new Fruit("오렌지", 200),
	        new Fruit("바나나", 50),
	        new Fruit("수박", 880),
	        new Fruit("체리", 10)
	};
	
    System.out.println();
    System.out.println("정렬전::");
    for ( Fruit city: arr)
    	System.out.print(" " + city);
	Arrays.sort(arr);

//구현 - 정렬
    System.out.println();
    System.out.println("정렬후::");
    for ( Fruit city: arr)
    	System.out.print(" " + city);

	ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
	ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
	lst2.add(new Fruit("복숭아", 200));
	lst2.add(new Fruit("포도", 300));
	lst2.add(new Fruit("참외", 100));
	lst2.add(new Fruit("딸기", 50));
	lst2.add(new Fruit("블루베리", 500));
	lst2.add(new Fruit("구지뽕", 300));
	System.out.println();
	System.out.println();
	System.out.println("새로운 리스트2::");
    for ( Fruit city: lst2)
    	System.out.print(" " + city);
//    Arrays.sort(lst2);
    Collections.sort(lst2);
    
	System.out.println();
	System.out.println("정렬 후 새로운 리스트2::");
    for ( Fruit city: lst2)
    	System.out.print(" " + city);
    
    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
	
	Iterator<Fruit> iter1 = lst1.iterator();
	Iterator<Fruit> iter2 = lst2.iterator();
	
//구현- merge를 iterator 사용
	Fruit s1 = iter1.next();
	Fruit s2 = iter2.next();

	while (iter1.hasNext() && iter2.hasNext()) {
		if (s1.compareTo(s2) > 0) {
			lst3.add(s2);

			if (iter2.hasNext()) {
				s2 = iter2.next();
			} else {
				break;
			}

		} else if (s1.compareTo(s2) == 0) {
			lst3.add(s1);

			if (iter1.hasNext()) {
				s1 = iter1.next();
			} else {
				break;
			}
			if (iter2.hasNext()) {
				s2 = iter2.next();
			} else {
				break;
			}

		} else {
			lst3.add(s1);
			if (iter1.hasNext()) {
				s1 = iter1.next();
			} else {
				break;
			}
		}
	}
	
	while (iter1.hasNext()) {
		lst3.add(s1);
		if (iter1.hasNext())
			s1 = iter1.next();
		else
			break;
	}
	while (iter2.hasNext()) {
		lst3.add(s2);
		if (iter2.hasNext())
			s2 = iter2.next();
		else
			break;
	}
	
	System.out.println();
	System.out.println();
    System.out.println("merge:: ");
    for ( Fruit city: lst3)
    	System.out.print(city+ " ");
    
    Fruit newFruit = new Fruit("참외", 100);
    //binary search - Comparator를 사용한 구현
    
    Comparator<Fruit> cc = new Comparator<Fruit>() {
    	public int compare(Fruit u1, Fruit u2) {
    		return u1.compareTo(u2);
    	}
	};
	
	
    System.out.println();
    System.out.println();
    if (Collections.binarySearch(lst3, newFruit, cc) > 0)
		System.out.println("조회결과 없다");
    else System.out.println("조회 결과 "+ Collections.binarySearch(lst3, newFruit, cc) +newFruit);
    
	}
}
