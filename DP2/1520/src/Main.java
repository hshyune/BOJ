import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int m = Integer.parseInt(sp[0]);
		int n = Integer.parseInt(sp[1]);

		int[][] map = new int[m + 1][n + 1];
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			sp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(sp[j - 1]);
			}
		}

		dp[1][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// right
				if (map[i][j] < map[i][j - 1]) {
					dp[i][j] += dp[i][j - 1];
				}
				// down
				if (map[i][j] < map[i - 1][j]) {
					dp[i][j] += dp[i - 1][j];
				}

			}
			for (int j = 1; j <= n; j++) {
				// left
				if (j + 1 <= n) {
					if (map[i][j] < map[i][j + 1]) {
						dp[i][j] += dp[i][j + 1];
					}
				}
				// up
				if (i + 1 <= m) {
					if (map[i][j] < map[i + 1][j]) {
						dp[i][j] += dp[i + 1][j];
					}
				}
			}
		}

//		for (int i = 0; i <= m; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//		System.out.println();
//
//		for (int i = 0; i <= m; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		System.out.println(dp[m][n]);
	}

}
