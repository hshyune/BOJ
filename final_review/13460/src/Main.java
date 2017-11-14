import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(solve());
	}

	public static int solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int m = Integer.parseInt(sp[1]);
		char[][] map = new char[n][m];

		Point r = null;
		Point o = null;
		Point b = null;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					System.out.println("r");
					r = new Point(i, j);
				}
				if (map[i][j] == 'O') {
					System.out.println("o");
					o = new Point(i, j);
				}
				if (map[i][j] == 'B') {
					System.out.println("b");
					b = new Point(i, j);
				}
			}
		}
		boolean[][][][] visit = new boolean[n][m][n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		int cnt = 0;
		Pair init = new Pair(r, b);
		q.add(init);
		int rx = q.peek().r.x;
		int ry = q.peek().r.y;
		int bx = q.peek().b.x;
		int by = q.peek().b.y;

		visit[ry][rx][by][bx] = true;
		while (!q.isEmpty()) {
			rx = q.peek().r.x;
			ry = q.peek().r.y;
			bx = q.peek().b.x;
			by = q.peek().b.y;
			q.poll();

			if (map[ry][rx] == 'O' && map[ry][rx] != map[by][bx]) {
				return cnt;
			}
			// N E S W
			for (int i = 0; i < 4; i++) {
				int nrx = rx;
				int nry = ry;
				int nbx = bx;
				int nby = by;
				// red move
				while ((nry + dy[i] > 0 && nry + dy[i] < n) && (0 <= nrx + dx[i] && nrx + dx[i] < n)
						&& (map[nry + dy[i]][nrx + dx[i]] != '#' || map[nry][nrx] != 'O')) {
					nrx += dx[i];
					nry += dy[i];
				}
				// blue move
				while ((nby + dy[i] > 0 && nby + dy[i] < n) && (0 <= nbx + dx[i] && nbx + dx[i] < n)
						&& (map[nby + dy[i]][nbx + dx[i]] != '#' || map[nby][nbx] != 'O')) {
					nbx += dx[i];
					nby += dy[i];
				}

				if ((nrx == nbx) && (nry == nby)) {
					if (map[nry][nrx] == 'O') {
						continue;
					}
					if (Math.abs(rx - nrx) + Math.abs(ry - nry) < Math.abs(bx - nbx) + Math.abs(by - nby)) {
						nbx -= dx[i];
						nby -= dy[i];
					} else {
						nrx -= dx[i];
						nry -= dy[i];
					}

					if (visit[nry][nrx][nby][nbx])
						continue;

					q.add(new Pair(new Point(nrx, nry), new Point(nby, nbx)));
					visit[nry][nrx][nby][nbx] = true;
				}
				if (cnt >= 10)
					return -1;
				cnt++;

			}
		}
		return 0;
	}

}

class Pair {
	Point r, b;

	public Pair(Point r, Point b) {
		this.r = r;
		this.b = b;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}