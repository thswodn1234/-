package chap6;

import java.util.Scanner;

//simple queue에 대한 성능 비교 실험, 난수를 사용하여 시간 측정
//MinPQ를 구현
class Element<Type> {
	public Type key;
	public Element() {
	}
	public Element(Type key) {
		this.key = key;
	}
}

interface MaxPQ<Type> {
	public void Insert();
	public Element<Type> DeleteMax();
}

abstract class MaxHeap<Type> implements MaxPQ<Type> {
	private int[] heap;
	int n; // current size of MaxHeap
	int MaxSize; // Maximum allowable size of MaxHeap
	void HeapEmpty() {
		System.out.println("Heap Empty" + "\n");
	};
	void HeapFull() {
		System.out.println("Heap Full");
	};

	public MaxHeap(int sz) {
		MaxSize = sz;
		n = 0;
		heap = new int[MaxSize + 1]; // Don't want to use heap[0]
	};

	void display() {
		int i;
		System.out.println("MaxHeap:: (i, heap[i].key): ");
		for (i = 1; i <= n; i++) {
			System.out.println("(" + i + ", " + heap[i].key + ") ");

		}
		System.out.println();
	};

	void Insert(Element<Type> x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++;
		for (i = n; i > 1; i--) {
			if (i == 1)
				break; // at root
			if ((int) x.key <= (int) heap[i / 2].key)
				break;
			// move from parent to i
			heap[i] = heap[i / 2];
			i /= 2;
		}
		heap[i] = x;
	};

	int DeleteMax(Element<Type> x) {
		int i, j;
		if (n < 0) {
			HeapEmpty();
			return 0;
		}
		x = heap[1];
		Element<Type> k = heap[n];
		n--;

		for (i = 1, j = 2; j <= n;) {
			if (j < n)
				if ((int) heap[j].key < (int) heap[j + 1].key)
					j++;
			// j points to the larger child
			if ((int) k.key >= (int) heap[j].key)
				break;
			heap[i] = heap[j];
			i = j;
			j *= 2;
		}
		heap[i] = k;
		return (int)x.key;
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
			 MaxHeap<Integer> heap(20);
			 Element<Integer> ele;
			
			 Element<Integer> deletedEle = null;

			do {
				System.out.println(
						"Max Tree. Select: 1 insert, 2 display, 3 delete, >=5 exit");
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
						 deletedEle = heap.DeleteMax(ele);
						 if (deletedEle != null) {
						System.out.println("deleted element: " + deletedEle.key);
						 }

						System.out.println("current max heap: ") ;
						 heap.display();
						 break;
					case 5 :
						 exit(1);
						 break;

				}
			} while (select < 5);
			stdin.close();
		}
	}
}
