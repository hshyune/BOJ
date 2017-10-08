import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int m = Integer.parseInt(sp[1]);
		int[][] arr = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			sp = br.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(sp[j - 1]);
			}
		}

		for (int i = 1; i <= n; i++) {
			dp[i][1] = (dp[i - 1][1] + arr[i][1]);
			for (int j = 2; j <= m; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
				dp[i][j] += arr[i][j];
			}
		}

		System.out.println(dp[n][m]);
	}

}
