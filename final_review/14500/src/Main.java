import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] drow = { -1, 0, 1, 0 };
	static int[] dcol = { 0, 1, 0, -1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		n = Integer.parseInt(sp[0]);
		m = Integer.parseInt(sp[1]);
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			sp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(sp[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(0,0,0,0);
				max = Math.max(cross(i, j), max);
			}
		}
		System.out.println(max);

	}

	public static void dfs(int depth, int row, int col, int sum) {
		if (depth == 4) {
			// for (int i = 0; i < n; i++) {
			// for (int j = 0; j < m; j++) {
			// if (visit[i][j])
			// System.out.print(1 + " ");
			// else
			// System.out.print(0 + " ");
			// }
			// System.out.println();
			// }

			max = Math.max(max, sum);
			
			return;
		}

		visit[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int nrow = row + drow[i];
			int ncol = col + dcol[i];
			if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
				continue;
			}
			if (visit[nrow][ncol])
				continue;
			dfs(depth + 1, nrow, ncol, sum + map[row][col]);
		}
		visit[row][col] = false;
	}

	// public static int dfs(int row, int col) {
	// int sum = 0;
	// int max = Integer.MIN_VALUE;
	// boolean[][] visit = new boolean[n][m];
	// LinkedList<Point> list = new LinkedList<Point>();
	// Stack<Point> s = new Stack<Point>();
	// Point p = new Point(row, col);
	// s.push(p);
	// visit[p.row][p.col] = true;
	//
	// while (!s.isEmpty()) {
	// if (s.size() == 4) {
	// sum = 0;
	// for (int i = 0; i < 4; i++) {
	// sum += map[s.get(i).row][s.get(i).col];
	// }
	// max = Math.max(sum, max);
	//
	// list.addLast(s.pop());
	// } else {
	// boolean flag = false;
	// int done = 0;
	// Point cp = s.peek();
	// for (int i = 0; i < 4; i++) {
	// Point np = new Point(cp.row + drow[i], cp.col + dcol[i]);
	//
	// if (np.row < 0 || np.row >= n || np.col < 0 || np.col >= m) {
	// done += 1;
	// continue;
	// }
	// if (!visit[np.row][np.col]) {
	// s.push(np);
	// visit[np.row][np.col] = true;
	// flag = true;
	// break;
	// } else {
	// done += 1;
	// }
	// }
	// if (!flag) {
	// s.pop();
	// }
	// if (done == 4) {
	// int size = list.size();
	// for (int i = 0; i < size; i++) {
	// visit[list.get(0).row][list.get(0).col] = false;
	// list.removeFirst();
	// }
	// }
	// }
	// }
	// return max;
	// }

	public static int cross(int row, int col) {
		int invalid = 0;
		int min = Integer.MIN_VALUE;
		int sum = map[row][col];
		for (int i = 0; i < 4; i++) {
			int nrow = row + drow[i];
			int ncol = col + dcol[i];
			if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
				invalid += 1;
				continue;
			}
			min = Math.min(min, map[nrow][ncol]);
			sum += map[nrow][ncol];
		}
		if (invalid == 1)
			return sum;
		if (invalid > 1)
			return -1;
		return (sum - min);
	}

}

class Point {
	int row;
	int col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
