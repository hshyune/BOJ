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
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
	}

	public static int dfs(int row, int col) {
		int sum = 0;
		boolean visit[][] = new boolean[n][m];
		Stack<Integer> s = new Stack<Integer>();
		int cv = row * m + col;
		s.push(cv);
		visit[row][col] = true;

		while (!s.isEmpty()) {
			System.out.println(s);
			if (s.size() == 4) {
				for (int i = 0; i < 4; i++) {
					System.out.print(s.get(i) + " ");
				}
				System.out.println();
				s.pop();
			} else {
				int crow = s.peek() / m;
				int ccol = s.peek() % m;
				int invalid = 0;
				visit[crow][ccol] = true;
				for (int i = 0; i < 4; i++) {
					int nrow = crow + drow[i];
					int ncol = ccol + dcol[i];
					if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
						invalid += 1;
						continue;
					}
					if (visit[nrow][ncol]) {
						invalid += 1;
						continue;
					} else {
						s.push(nrow * m + ncol);
						break;
					}

				}
				if (invalid == 4) {
					for (int i = 0; i < 4; i++) {
						int nrow = crow + drow[i];
						int ncol = ccol + dcol[i];
						if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
							continue;
						}
						if (!s.contains(nrow * m + ncol)) {
							visit[nrow][ncol] = false;
						}
					}
					visit[crow][ccol] = true;
					s.pop();
				}
			}
		}
		return sum;
	}
}
