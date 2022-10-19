package 자바자료구조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Chap1_StringMerge {
	public static String[] removeElement(String[] arr, String item) {
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		list.remove(item);
		return list.toArray(String[]::new);
	}

	public static String[] removeDuplicate(String[] lst) {
		int count = lst.length;
		for (int i = 0; i < count; i++) {
			// for (int j = i + 1; j < count; j++)
			int j = i + 1;
			while (j < count) {
				if ((lst[i].compareTo(lst[j])) == 0) {
					lst = removeElement(lst, lst[j]);
					count--;
					// System.out.println("j = " + j + " count = " + count);
				} else
					j++;
			}
		}
		return lst;
	}
	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("서울");
		list1.add("북경");
		list1.add("상해");
		list1.add("도쿄");
		list1.add("서울");
		list1.add("서울");
		list1.add("뉴욕");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("런던");
		list2.add("로마");
		list2.add("방콕");
		list2.add("북경");
		list2.add("도쿄");
		list2.add("서울");
		list2.add("서울");
		list2.add("서울");
		list2.add("서울");
		list2.add("수원");
		list2.add("수원");
		list2.add("수원");
		list2.add("화성");

		list2.add(1, "LA");

		//
		System.out.println("collection.sort()::");
		Collections.sort(list1);
		Collections.sort(list2);
		System.out.println("list1::");
		for (String city : list1)
			System.out.print(city + " ");
		System.out.println();
		System.out.println("list2::");
		for (String city : list2)
			System.out.print(city + " ");

		String[] lst1 = new String[0];
		lst1 = list1.toArray(lst1);
		String[] lst2 = new String[0];
		lst2 = list2.toArray(lst2);
		System.out.println();
		lst1 = removeDuplicate(lst1);
		lst2 = removeDuplicate(lst2);
		System.out.println();
		System.out.println("list1::");
		for (String city : lst1)
			System.out.print(city + " ");
		System.out.println();
		System.out.println("list2::");
		for (String city : lst2)
			System.out.print(city + " ");

		String[] lst3 = new String[20];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < lst1.length && j < lst2.length) {
			if (lst1[i].compareTo(lst2[j]) < 0) { // 인덱스 값 비교
				lst3[k] = lst1[i];
				i++;
				k++;
			} else if (lst1[i].compareTo(lst2[j]) > 0) {
				lst3[k] = lst2[j];
				j++;
				k++;
			} else {
				lst3[k] = lst1[i];
				i++;
				j++;
				k++;

			}
		}

		while (i < lst1.length) {
			lst3[k] = lst1[i];
			i++;
			k++;
		}

		while (j < lst2.length) {
			lst3[k] = lst2[j];
			j++;
			k++;
		}

		System.out.println();
		System.out.println();
		System.out.println("lst3::");
		for (String city : lst3)
			System.out.print(city + " ");
	}

}
