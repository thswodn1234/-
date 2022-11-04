package chap5_Recursive;

import java.util.Stack;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//N Queen problem / backtracking
class Point1 {
	int x, y;

	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Backtracking_Queen1 {

	public static void SolveQueen(int[][] d) {

		int count = 0;
		int ix = 0, iy = 0;

		Stack<Point> st = new Stack<>();

		Point p = new Point(ix, iy);

		System.out.println("while " + ix + " " + iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);
		int iq = 0;
		ix++;

		while (count < 8) {
			
			while (ix < d.length) {
				int cy = 0;
				
				
				cy = NextMove(d, ix, cy);
				if (cy == d.length) {

					while (cy == d.length) {

						p = st.pop();
						d[p.x][p.y] = 0;
						if(p.y == 7) {
							p = st.pop();
						} else {
							p.y++;
						}
						cy = NextMove(d, p.x, p.y);

					}
					ix = p.x;
					cy = p.y;
				}

				d[ix][cy] = 1;
				count++;
				System.out.println("while " + ix + " " + cy);

				Point p2 = new Point(ix, cy);
				st.push(p2);
				ix++;
				
			}
			iq++;

		}
	}

	public static boolean checkRow(int[][] d, int crow) {

		for (int i = 0; i < d[0].length; i++)
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
		for (int i = cx, j = cy; 0 <= i && i < 7 && 0 <= j && j <= 7; i++, j--)
			if (d[i][j] == 1)
				return false;
		for (int i = cx, j = cy; 0 <= i && i < 7 && 0 <= j && j <= 7; i--, j++)
			if (d[i][j] == 1)
				return false;

		return true;
	}

	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++,
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

	public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동
		// 가능한지를
		// check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSE(d, x, y)
				&& checkDiagSW(d, x, y))
			return true;
		return false;

	}

	public static int NextMove(int[][] d, int row, int col) {
		// 특정 row에 대하여 col을 이동하여 이동할 체크하고 위치 col을 리턴한다
		while (col < d[0].length) {
			if (CheckMove(d, row, col))
				return col;
			col++;

		}
		return d.length;// 이유는?
	}

}

public class Queen {
	public static void main(String[] args) {

		int row = 8, col = 8;
		int[][] data = new int[row][col];

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		Backtracking_Queen1.SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}

}
