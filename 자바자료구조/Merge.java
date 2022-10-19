package 자바자료구조;
import java.util.ArrayList;
import java.util.Arrays;

public class Merge { // 두개의 배열에서 각각 원소비교해서 하나의 Arraylist로 정렬
	public static void main(String[] args) {

		int[] L1 = {1,2,3,4};

		int[] L2 = {100,102,103,107,99};
		
		
		Arrays.sort(L1);
		Arrays.sort(L2);

		System.out.println(Arrays.toString(L1));
		System.out.println(Arrays.toString(L2));
		ArrayList<Integer> L3 = new ArrayList<>();

		int i = 0; // L1의 인덱스
		int k = 0; // L2의 인덱스

		do {
			if (L1[i] < L2[k]) { // 인덱스 값 비교
				L3.add(L1[i]);
				i++;
			} else if (L1[i] > L2[k]) {
				L3.add(L2[k]);
				k++;
			}
		} while (k != L2.length && i != L1.length);

		
		if (k == L2.length) { // 비교 불가능할 때 실행 (L1 또는 L2 원소 다 넣음)
			for (int x = i; x <= L1.length - 1; x++) {
				L3.add(L1[x]);
			}
		} else if (i == L1.length) {
			for (int y = k; y <= L2.length - 1; y++) {
				L3.add(L2[y]);
			}
		}

		System.out.println(L3);
	}
}
