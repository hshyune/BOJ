import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		String[] sp = null;

		for (int i = 0; i < n; i++) {
			sp = br.readLine().split(" ");
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(sp[j]);
			}
		}

		dp[0][0] = arr[0][0];
		if (n >= 2) {
			dp[1][0] = arr[0][0] + arr[1][0];
			dp[1][1] = arr[0][0] + arr[1][1];
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
			dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[n - 1][i]);
		}
		System.out.println(max);
	}

}
