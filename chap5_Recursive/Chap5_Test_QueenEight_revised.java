
import java.util.Stack;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//N Queen problem / backtracking
class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Backtracking_Queen {

	public static void SolveQueen(int[][] d) {

		int count = 0; // 퀸 개수
		int ix = 0, iy = 0; // ix : 행

		Stack<Point> st = new Stack<>();
		Point p = new Point(ix, iy);
		st.push(p);

		int cy = 0; // cy : 열

		while (count < 8) {

			while (ix < d.length) {
				cy = NextMove(d, ix, iy); // 해당 행에 퀸을 놓을 수 있는지 체크
				if (cy == d.length) { // 해당 행 불가능
					do {
						p = st.pop(); // 이전 퀸 놓았던 행,열 반환 (한 행에 무조건 퀸 1개 있어야함 )
						d[p.x][p.y] = 0;
						System.out.println("d[" + p.x + "]" + "[" + p.y + "]" + " = 0");
						count--;
						System.out.println("count : " + count);
						ix = p.x;
						cy = ++p.y; // 이전 퀸 놓았던 바로 옆자리 체크
						cy = NextMove(d, ix, cy);
					} while (cy == d.length);

				}
				System.out.println("d[" + ix + "]" + "[" + cy + "]" + " = 1");
				d[ix][cy] = 1;
				count++;
				System.out.println("count : " + count);
				Point p2 = new Point(ix, cy);
				st.push(p2);
				ix++; // 행 증가
			}

		}

	}

	public static boolean checkRow(int[][] d, int crow) {

		for (int i = 0; i < d.length; i++)
			if (d[crow][i] == 1)
				return false;
		return true;

	}

	public static boolean checkCol(int[][] d, int ccol) {

		for (int i = 0; i < d.length; i++)
			if (d[i][ccol] == 1)
				return false;
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++,
		// y--
		// or
		// x--,
		// y++
		// where
		// 0<=
		// x,y
		// <= 7
		for (int i = cx, j = cy; 0 <= i && i <= 7 && 0 <= j && j <= 7; i++, j--)
			if (d[i][j] == 1)
				return false;
		for (int i = cx, j = cy; 0 <= i && i <= 7 && 0 <= j && j <= 7; i--, j++)
			if (d[i][j] == 1)
				return false;

		return true;
	}

	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++,
		// y++
		// or
		// x--,
		// y--

		for (int i = cx, j = cy; 0 <= i && i <= 7 && 0 <= j && j <= 7; i++, j++)
			if (d[i][j] == 1)
				return false;
		for (int i = cx, j = cy; 0 <= i && i <= 7 && 0 <= j && j <= 7; i--, j--)
			if (d[i][j] == 1)
				return false;

		return true;
	}

	public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동
		// 가능한지를
		// check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSE(d, x, y) && checkDiagSW(d, x, y))
			return true;
		return false;

	}

	public static int NextMove(int[][] d, int row, int col) {
		// 특정 row에 대하여 col을 이동하여 이동할 체크하고 위치 col을 리턴한다
		while (col < d.length) {
			if (CheckMove(d, row, col))
				return col;
			++col;

		}
		return d.length;// 이유는?
	}

}

public class Chap5_Test_QueenEight_revised {
	public static void main(String[] args) {

		int row = 8, col = 8;
		int[][] data = new int[row][col];

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		Backtracking_Queen.SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}

}
