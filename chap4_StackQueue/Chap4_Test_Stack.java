package chap4_StackQueue;

import java.util.Scanner;

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

class Stack {
	private Point[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmptyIntStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public OverflowIntStackException() {
		}
	}

	// --- 생성자(constructor) ---//
	public Stack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new Point[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public Point push(Point p) throws OverflowIntStackException {
		if (ptr >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		return stk[ptr++] = p;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyIntStackException {
		if (ptr <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyIntStackException {
		if (ptr <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// --- 스택을 비움 ---//
	public void clear() {
		ptr = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = ptr - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (stk[i].equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return ptr;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return ptr >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}

public class Chap4_Test_Stack {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Stack s = new Stack(8); // 최대 64 개를 푸시할 수 있는 스택
		
		int rndx = 0, rndy = 0;

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(),
					s.getCapacity());
			System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(0)종료: ");
			
			int menu = stdIn.nextInt();
			if (menu == 0)
				break;
			
			
			rndx = (int)(Math.random()*9 + 1);
			rndy = (int)(Math.random()*9 + 1);
			
			Point p = new Point(rndx, rndy);
			
			switch (menu) {
				case 1 : // 푸시
					System.out.print("데이터: ");

					if (s.isFull())
						System.out.println("스택이 가득찼있습니다.");
					else {
						s.push(p);
					}
					break;

				case 2 : // 팝
					if (s.isEmpty())
						System.out.println("스택이 비어있습니다.");
					else {
						p = s.pop();
						System.out.println("팝한 데이터는 " + p + "입니다.");
					}
					break;

				case 3 : // 피크
					if (s.isEmpty())
						System.out.println("스택이 비어있습니다.");
					else {
						p = s.peek();
						System.out.println("피크한 데이터는 " + p + "입니다.");
					}
					break;

				case 4 : // 덤프
					s.dump();
					break;
			}
		}
		stdIn.close();
	} 
	
}

