package chap5_Recursive;

//class Point {
//	private int ix;
//	private int iy;
//
//	public Point(int x, int y) {
//		ix = x;
//		iy = y;
//	}
//
//	public String toString() {
//		return "<" + ix + ", " + iy + ">";
//	}
//
//	public int getX() {
//		return ix;
//	}
//
//	public int getY() {
//		return iy;
//	}
//
//	public void setX(int x) {
//		ix = x;
//	}
//
//	public void setY(int y) {
//		iy = y;
//	}
//}

class Stack {
	private items[] stk; // 스택용 배열
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
			stk = new items[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public items push(items p) throws OverflowIntStackException {
		if (ptr >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		return stk[ptr++] = new items(p) ;    // 스택은 객체 주소 복사하기 때문에 // p 쓰면 같은 주소 참조
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public items pop() throws EmptyIntStackException {
		if (ptr <= -1) // 스택이 빔
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public items peek() throws EmptyIntStackException {
		if (ptr <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// --- 스택을 비움 ---//
	public void clear() {
		ptr = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(items x) {
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
class items {
	int x, y, dir;
	
	public items(items it) {
		x = it.x;
		y = it.y;
		dir = it.dir;
		
	}
	public items(int a, int b, int c) {
		x = a;
		y = b;
		dir = c;
	}

	public String toString() {
		return this.x + "," + this.y + "," + this.dir;
	}
}

class offsets {
	public int a, b;

	public offsets(int i, int j) {
		this.a = i;
		this.b = j;
	}

}
public class MazingProblemJava {



	static offsets[] moves = new offsets[8];

	static int[][] maze = new int[100][100];
	static int[][] mark = new int[100][100];

	public void path(int m, int p) {
		//// Output a path (if any) in the maze; rows is m, cols is p;

		// //start at (1,1)
		mark[1][1] = 1;
		Stack stack = new Stack(100);

		items temp = new items(1,1,2);

		temp.x = 1;
		temp.y = 1;
		temp.dir = 2;
		stack.push(temp);

		while (!stack.isEmpty()) // stack not empty
		{
			temp = stack.pop(); // unstack
			int i = temp.x;
			int j = temp.y;
			int d = temp.dir;
			stack.dump();
			
			while (d < 8) // moves forward
			{
				System.out.println(i + " " + j + " " + d );
				
				// 좌표
				int g = i + moves[d].a;
				int h = j + moves[d].b;

				if ((g == m) && (h == p)) { // reached exit
					// output path
					

					System.out.println("the term near the exit: " + i + " " + j);
					System.out.println("exit: " + m + " " + p);
					return;
				}

				if ((maze[g][h] == 0) && (mark[g][h]) == 0) { // new
																// position
					mark[g][h] = 1;
					// push the old temp to the stack, but the direction
					// changes.
					// Because the neighbor in the direction of d has been
					// checked.
					
					temp.x = i;  temp.y = j; temp.dir = d;
					
					stack.push(temp); 
					
					
				
					
					i = g;
					j = h;
					d = 0;
			
				
				} else 
					d++; // try next direction
			}
		}
		System.out.println("no path in maze ");
	}

	/// *
	// maze[][], mark[][]를 class의 private data member로 선언
	// main()에서는 class의 public function의 호출로 미로 찾기
	// */
	// void main() {
	public static void main(String[] args) {
		MazingProblemJava mp = new MazingProblemJava();

		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new offsets(0, 0);

		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;

		int input[][] = { // 12 x 15
				{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1},
				{1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1},
				{0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
				{1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0},
				{1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1},
				{0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1},
				{0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
				{1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
				{0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0}};

		// 테두리
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;

			}
		}

		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}

		System.out.println();
		System.out.println("mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

		mp.path(12, 15);

		System.out.println();
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

	}
}
