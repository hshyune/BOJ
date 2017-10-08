import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int[][] arr = new int[n + 1][n + 1];
		long[][] dp = new long[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			sp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(sp[j - 1]);
			}
		}
		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i][j] == 0 || (i == n && j == n))
					continue;
				int dist = arr[i][j];

				if ((j + dist) <= n) {
					dp[i][j + dist] += dp[i][j];
				}
				if ((i + dist) <= n) {
					dp[i + dist][j] += dp[i][j];
				}
			}

		}

		System.out.println(dp[n][n]);
	}

}
