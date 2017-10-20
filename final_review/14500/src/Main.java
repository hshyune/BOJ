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
				dfs(0, i, j, 0);
				cross(i, j);
			}
		}

		System.out.println(max);

	}

	public static void dfs(int depth, int row, int col, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		visit[row][col] = true;
		for (int i = 0; i < 4; i++) {
			Point np = new Point(row + drow[i], col + dcol[i]);
			if (np.row < 0 || np.row >= n || np.col < 0 || np.col >= m) {
				continue;
			}
			if (!visit[np.row][np.col])
				dfs(depth + 1, np.row, np.col, sum + map[row][col]);
		}
		visit[row][col] = false;
	}

	public static void cross(int row, int col) {
		int invalid = 0;
		int min = Integer.MAX_VALUE;
		int sum = map[row][col];
		for (int i = 0; i < 4; i++) {
			Point np = new Point(row + drow[i], col + dcol[i]);
			if (np.row < 0 || np.row >= n || np.col < 0 || np.col >= m) {
				invalid += 1;
				continue;
			}
			min = Math.min(min, map[np.row][np.col]);
			sum += map[np.row][np.col];
		}

		if (invalid == 0) {
			max = Math.max(max, sum-min);
			return;
		}
		if (invalid == 1) {
			max = Math.max(max, sum);
		}
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
