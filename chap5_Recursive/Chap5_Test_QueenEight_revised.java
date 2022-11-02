package chap5_Recursive;

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

		int count = 0;
		int ix = 0, iy = 0;

		Stack<Point> st = new Stack<>();

		Point p = new Point(ix, iy);

		System.out.println("while  " + ix + " " + iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);

		while (count < 8) {
			p = st.pop();
			ix = p.x;
			iy = p.y;
			
			ix++;
			int cy = 0;
			while (ix < d.length) {
				
				cy = NextMove(d, ix, cy);
				while(cy == d.length) {
					ix++;
					cy = 0;
					cy = NextMove(d, ix, cy);
				}
				System.out.println("while  " + ix + " " + cy);
				
				while (cy < d[0].length) {
					d[ix][cy] = 1;
					count++;
					Point px = new Point(ix, cy);
					st.push(px);
					ix++;
					cy=0;
					break;

				}

			}

			if (cy != d[0].length) {
				break;
			} else {
				p = st.pop();
				count--;
				ix = p.x;
				cy = p.y;
				cy++;

			}
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