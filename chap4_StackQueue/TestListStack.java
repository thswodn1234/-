package chap4_StackQueue;





	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class TestListStack <E> {
		private int capacity; // 스택 용량
		private int ptr; // 스택 포인터
		private List<E> stk; // 스택용 배열
		
		public TestListStack (int count) {
			capacity = count;
			stk = new ArrayList<E>();
		}
		//예외
//		public static class EmptyGstackException extends RuntimeException {
//			public EmptyGstackException() {
//			}
//		}
	//
//		public static class OverflowGstackException extends RuntimeException {
//			public OverflowGstackException() {
//			}
//		}

		public boolean isStackFull() {
			return (this.capacity - 1 == ptr);
		}
		public boolean isStackEmpty() {
			return (this.ptr == -1);
		}



		public void push(E element) {
			
			if (this.isStackFull()) {
				System.out.println("Stack is full");
				
			} else
				System.out.println("PUSH:" + element);
				++ptr;
				stk.add(element);
		}

		public E pop() {
			if (this.isStackEmpty()) {
				System.out.println("Stack is empty");
			}

			return (E) stk[ptr--];

		}

		public int peek() {
			System.out.println("peeking:" + this.stk[ptr]);
			return (int) stk[ptr];
		}

		public int getCapacity() {
			return capacity;
		}
		public int size() {
			return ptr;
		}

		public boolean isEmpty() {
			return ptr <= 0;
		}

		public boolean isFull() {
			return ptr >= capacity;
		}

		public void dump() {
			if (ptr <= 0)
				System.out.println("스택이 비어 있습니다.");
			else {
				for (int i = 0; i <= ptr; i++)
					System.out.println(stk[i] + " ");
				System.out.println();
			}
		}

		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);
			TestGenericStack<Integer> s = new TestGenericStack<Integer>(5);
			// 최대 64 개를 푸시할 수 있는 스택

			while (true) {
				System.out.println(); // 메뉴 구분을 위한 빈 행 추가
				System.out.printf("현재 데이터 개수: %d / %d\n", s.size(),
						s.getCapacity());
				System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(0)종료: ");

				int menu = stdIn.nextInt();
				if (menu == 0)
					break;

				Integer x = null;
				switch (menu) {
					case 1 : // 푸시
						System.out.print("데이터: ");
						x = (Integer) stdIn.nextInt();
						if (s.isFull())
							System.out.println("스택이 가득찼있습니다.");
						else {
							s.push(x);

							break;
						}

					case 2 : // 팝
						if (s.isEmpty())
							System.out.println("스택이 비어있습니다.");
						else {

							x = s.pop();
							System.out.println("팝한 데이터는 " + x + "입니다");

						}
						break;

					case 3 : // 피크
						if (s.isEmpty())
							System.out.println("스택이 비어있습니다.");
						else {
							x = s.peek();
							System.out.println("피크한 데이터는 " + x + "입니다.");
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

}
