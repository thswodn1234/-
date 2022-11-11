package chap6;

import java.util.Scanner;

//simple queue에 대한 성능 비교 실험, 난수를 사용하여 시간 측정
//MinPQ를 구현
//class Element {
//	public Type key;
//	public Element() {
//	}
//	public Element(Type key) {
//		this.key = key;
//	}
//}

interface MaxPQ {
	public void Insert(int n);
	public int DeleteMax();
}

class MaxHeap implements MaxPQ {
	private int[] heap;
	int n; // current size of MaxHeap
	int MaxSize; // Maximum allowable size of MaxHeap
	void HeapEmpty() {
		System.out.println("Heap Empty" + "\n");
	}
	void HeapFull() {
		System.out.println("Heap Full");
	}

	public MaxHeap(int sz) {
		MaxSize = sz;
		n = 0;
		heap = new int[MaxSize + 1]; // Don't want to use heap[0]
	}

	void display() {
		int i;
		System.out.println("MaxHeap:: (i, heap[i]): ");
		for (i = 1; i <= n; i++) {
			System.out.println("(" + i + ", " + heap[i] + ") ");

		}
		System.out.println();
	}

	public void Insert(int x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++;
		for (i = n; i > 1; ) {
			if (i == 1)
				break; // at root
			if (x <= heap[i / 2])
				break;
			// move from parent to i
			int tmp = heap[i]; 
			heap[i] = heap[i / 2];
			heap[i / 2] = tmp;
			i /= 2;
		}
		heap[i] = x;
	}

	public int DeleteMax() {
		int i, j, x;
		if (n < 1) {
			HeapEmpty();
			return 0;
		}
		x = heap[1];
		int k = heap[n];
		n--;

		for (i = 1, j = 2; j <= n;) {
			if (j < n)
				if (heap[j] < heap[j + 1])
					j++;
			// j points to the larger child
			if (k >= heap[j])
				break;
			heap[i] = heap[j];
			i = j;
			j *= 2;
		}
		heap[i] = k;
		return x;
	}
}
	public class HeapSort {
		final int HeapSize = 1000;
		enum Boolean {
			FALSE, TRUE
		}

		public static void main(String[] args) {

			int select = 0;
			int data = 0;
			Scanner stdin = new Scanner(System.in);
			MaxHeap heap = new MaxHeap(50);
			

			int deletedEle = 0;

			do {
				System.out.println(
						"Max Heap Tree. Select: 1 insert, 2 display, 3 delete, >=5 exit");
				select = stdin.nextInt();

				switch (select) {
					case 1 :
						System.out.println("input value: ");
						data = stdin.nextInt();
						heap.Insert(data);
						heap.display();
						break;
					case 2 :
						heap.display();
						break;
					case 3 :

						deletedEle = heap.DeleteMax();
						if (deletedEle != 0) {
							System.out
									.println("deleted element: " + deletedEle);
						}

						System.out.println("current max heap: ");
						heap.display();
						break;
					case 5 :
						System.out.println("exit ");
						break;

				}
			} while (select < 5);
			stdin.close();
		}
	}
