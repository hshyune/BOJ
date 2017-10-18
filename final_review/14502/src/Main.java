import java.io.*;
import java.util.*;

public class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(map));
	}

	public static int dfs(int[][] map) {
		int[][] tmp = copy(map);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int next = next(tmp);
		while (true) {
			next = next(tmp);
			if (next == -1)
				break;
			list.add(next);
			tmp[next / m][next % m] = 1;
		}

		ArrayList<Integer> virusList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					virusList.add(i * n + j);
				}
			}
		}

		int index = 0;
		int max = Integer.MIN_VALUE;
		boolean[] visit = new boolean[list.size()];
		Stack<Integer> s = new Stack<Integer>();
		s.push(list.get(index));
		visit[index] = true;
		while (!s.isEmpty()) {
			if (s.size() == 3) {
				tmp = copy(map);
				for (int i = 0; i < 3; i++) {
					tmp[s.get(i) / m][s.get(i) % m] = 1;
					// System.out.print(s.get(i) + " ");
				}
				// System.out.println(spread(tmp, virusList));
				// paint

				max = Math.max(max, spread(tmp, virusList));
				s.pop();
			} else {
				if (index + 1 < list.size()) {
					index += 1;
					if (!visit[index]) {
						s.push(list.get(index));
						visit[getIndex(list, s.peek())] = true;
					}
				} else {
					index = getIndex(list, s.peek());
					for (int i = index + 1; i < list.size(); i++) {
						visit[i] = false;
					}
					s.pop();

					if (s.isEmpty()) {
						int notyet = 0;
						for (int i = 0; i < list.size(); i++) {
							if (!visit[i])
								notyet += 1;
						}
						if (notyet >= 3) {
							index += 1;
							s.push(list.get(index));
							visit[index] = true;
						} else {
							break;
						}
					}
				}
			}
		}
		return max;
	}

	public static int spread(int[][] map, ArrayList<Integer> list) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int[] drow = { 0, 0, 1, -1 };
		int[] dcol = { 1, -1, 0, 0 };

		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}
		while (!q.isEmpty()) {
			int now = q.peek();
			int row = now / m;
			int col = now % m;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];
				if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m || map[nrow][ncol] != 0) {
					continue;
				}
				q.add((nrow) * m + ncol);
				map[nrow][ncol] = 2;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static int next(int[][] map) {
		int p = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					return (i * m) + (j);
				}
			}
		}
		return p;
	}

	public static int findVirus(int[][] map) {
		int p = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					return (i * m) + (j);
				}
			}
		}
		return p;
	}

	public static int[][] copy(int[][] src) {
		int[][] dst = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dst[i][j] = src[i][j];
			}
		}
		return dst;

	}

	public static int getIndex(ArrayList<Integer> list, int value) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == value) {
				return i;
			}
		}
		return index;
	}
}
