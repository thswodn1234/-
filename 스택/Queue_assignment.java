package Chap5_Recursive;

public class Queue_assignment {

}
package Chap4_StackQueue;

import java.util.ArrayList;
import java.util.List;

//int형 고정 길이 큐

public class Queue {
//	private int[] que; // 큐용 배열
	private List<Integer> que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

//--- 생성자(constructor) ---//
public Queue(int maxlen) {

   try {
//       que = new int[capacity];          // 큐 본체용 배열을 생성

   } catch (OutOfMemoryError e) {        // 생성할 수 없음
       capacity = 0;
   }
}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowQueueException {
		if (num >= capacity)
			throw new OverflowQueueException(); // 큐가 가득 찼음

		num++;
		if (rear == capacity)
	
		return x;
	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException(); // 큐가 비어있음

	
		if (front == capacity)
			front = 0;
		return x;
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException(); // 큐가 비어있음

	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;

				return idx;
		}
		return -1; // 검색 실패
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어있습니다.");
		else {
			for (int i = 0; i < num; i++)

			System.out.println();
		}
	}
}