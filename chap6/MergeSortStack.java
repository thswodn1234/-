package chap6;

// 재귀 이용 -> merge 할때 배열 생성해서 넣고 복사
public class MergeSortStack {
	static int[] copy;

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(int[] a, int lefta, int righta, int leftb, int rightb) {
		int i = lefta; // a의 인덱스
		int j = leftb; // b의 인덱스
		int index = lefta;

		while (i <= righta && j <= rightb) {

			if (a[i] <= a[j]) { // 인덱스 값 비교
				copy[index++] = a[i++];

			} else if (a[i] > a[j]) {
				copy[index++] = a[j++];

			}
		}

		// 남아 있는 값들을 copy[]에 넣기
		if (i > righta) {
			for (int k = j; k <= rightb; k++)
				copy[index++] = a[k];
		}
		else {
			for (int k = i; k <= righta; k++)
				copy[index++] = a[k];
		}
		
		// a[]에 copy[] 복사
		for (int l = lefta; l <= rightb; l++) {
			a[l] = copy[l];
		}
	}

	

	// --- 병합 정렬(재귀 버전)---//
	static void MergeSort(int[] a, int left, int right) {
		if (left < right) {

			int mid = (left + right) / 2;

			MergeSort(a, left, mid);
			MergeSort(a, mid + 1, right);
			merge(a, left, mid, mid + 1, right);
		}

	}

	public static void main(String[] args) {
		int nx = 20;
		int[] x = new int[20];
		for (int ix = 0; ix < 20; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 50);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		copy = new int[nx];
		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
