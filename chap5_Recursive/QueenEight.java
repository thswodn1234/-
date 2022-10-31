package chap5_Recursive;
import java.util.Stack;

class Point1 {
	int x, y;

	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Backtracking_Queen1 {

	public boolean checkRow(int[][] d, int crow) {

		for (int i = 0; i < d[i].length;)
			if (d[crow][i] == 1)
				return false;
		return true;

	}

	public boolean checkCol(int[][] d, int ccol) {

		for (int i = 0; i < d[i].length;)
			if (d[i][ccol] == 1)
				return false;
		return true;
	}

	public boolean checkDiagSW(int[][] d, int cx, int cy) { // x++,
															// y--
															// or
															// x--,
															// y++
															// where
															// 0<=
															// x,y
															// <= 7
		for (int i = cx, j = cy; 0 <= i && i < 7 && 0 <= j && j <= 7; i++, j--)
			if (d[i][j] == 1)
				return false;
		for (int i = cx, j = cy; 0 <= i && i < 7 && 0 <= j && j <= 7; i--, j++)
			if (d[i][j] == 1)
				return false;

		return true;
	}

	public boolean checkDiagSE(int[][] d, int cx, int cy) {// x++,
															// y++
															// or
															// x--,
															// y--

		for (int i = cx, j = cy; 0 <= i && i < 7 && 0 <= j && j <= 7; i++, j++)
			if (d[i][j] == 1)
				return false;
		for (int i = cx, j = cy; 0 <= i && i < 7 && 0 <= j && j <= 7; i--, j--)
			if (d[i][j] == 1)
				return false;

		return true;
	}

	public boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동
														// 가능한지를
														// check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSE(d, x, y)
				&& checkDiagSW(d, x, y))
			return true;
		else
			return false;

	}

	public boolean NextMove(int[][] d, int row, int col) {// 다음 row에
															// 대하여
															// 이동할
															// col을
															// 조사
		if (CheckMove(d, row, col))
			return true;
		else
			return false;

	}

	public void SolveQueen(int[][] d) {

		int count = 0;
		int ix = 0, iy = 0;

		Stack<Point1> st = new Stack<>();

		Point1 p = new Point1(ix, iy);

		d[ix][iy] = 1;
		count++;
		st.push(p);

		while (count < 8) {
			ix++;
			int cy = 0;
			while (ix < d.length) {

				while (cy < d[0].length) {

					if (NextMove(d, ix, cy) == true) {

						iy = cy;
						st.push(p);
						count++;
						
						break;

					} else
						cy++;

				}

				if (cy != d[0].length) {
					break;
				} else {
					p = st.pop();
					count--;

				}

			}

		}
	}

}
public class QueenEight {

	public static void main(String[] args) {
		Backtracking_Queen1 bq = new Backtracking_Queen1();
		
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		bq.SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}

	}

}
