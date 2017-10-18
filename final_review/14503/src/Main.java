import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int CLEAN = 2;
	static final int WALL = 1;
	static final int DIRTY = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);

		String[] sp = br.readLine().split(" ");
		N = Integer.parseInt(sp[0]);
		M = Integer.parseInt(sp[1]);
		sp = br.readLine().split(" ");
		int row = Integer.parseInt(sp[0]);
		int col = Integer.parseInt(sp[1]);
		int dir = Integer.parseInt(sp[2]);
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			sp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(sp[j]);
			}
		}
		System.out.println(solve(map, row, col, dir));

	}

	public static int solve(int[][] map, int row, int col, int dir) {
		int cnt = 0;
		int[] drow = { -1, 0, 1, 0 };
		int[] dcol = { 0, 1, 0, -1 };

		while (true) {
			if (map[row][col] == DIRTY) {
				map[row][col] = CLEAN;
				cnt++;
			}

			boolean find = false;
			for (int i = 0; i < 4; i++) {
				int ndir = (dir - 1 + 4) % 4;
				int nrow = row + drow[ndir];
				int ncol = col + dcol[ndir];
				if (map[nrow][ncol] == DIRTY) {
					dir = ndir;
					row = nrow;
					col = ncol;
					find = true;
					break;
				} else {
					dir = ndir;
				}
			}

			if (find) {
				continue;
			} else {
				if (map[row - drow[dir]][col - dcol[dir]] == WALL) {
					break;
				} else {
					row = row - drow[dir];
					col = col - dcol[dir];
				}
			}
		}

		return cnt;
	}

}
