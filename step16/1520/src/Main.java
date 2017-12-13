import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] arr, dp;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp = br.readLine().split(" ");
		N = Integer.parseInt(sp[0]);
		M = Integer.parseInt(sp[1]);
		arr = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			sp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(sp[j]);
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(N - 1, M - 1));

	}

	public static int dfs(int y, int x) {
		if (x == 0 && y == 0) {
			return 1;
		}

		if (dp[y][x] == -1) {
			dp[y][x] = 0;
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;

				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					if (arr[y][x] < arr[ny][nx]) {
						dp[y][x] += dfs(ny, nx);
					}
				}
			}
		}
		return dp[y][x];
	}

}
