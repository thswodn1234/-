package chap6;

//퀵 정렬(스택을 이용한)

import java.util.Scanner;
import java.util.Stack;
//import java.math.*;

public class QuickSort {
	
	static class Point {
		private int ix;
		private int iy;

		public Point(int x, int y) {
			ix = x;
			iy = y;
		}
	}
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	
	static void quickSort(int[] a, int left, int right) {
	
		Stack<Point> stack = new Stack<>();
		
		Point p = new Point(left, right);

		stack.push(p);

		while (stack.isEmpty() != true) {
			p = stack.pop();
			
			int pl = left = p.ix; 
			int pr = right = p.iy; 
			int x = a[(left + right) / 2]; 

			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			if (left < pr) {
				Point p2 = new Point(left, pr);
				stack.push(p2);
				
			}
			if (pl < right) {
				Point p3 = new Point(pl, right);
				stack.push(p3);
			}
		}
	}


		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);

			System.out.println("퀵 정렬");
			System.out.print("요솟수: ");
			int nx = stdIn.nextInt();
			int[] x = new int[nx];

			for (int i = 0; i < nx; i++) {
				System.out.print("x[" + i + "]: ");
				double d = Math.random();
				x[i] = (int) (d * 50);
			}

			quickSort(x, 0, nx - 1); 

			System.out.println("오름차순으로 정렬했습니다.");
			for (int i = 0; i < nx; i++)
				System.out.println("x[" + i + "]=" + x[i]);
			stdIn.close();
		}
	}

