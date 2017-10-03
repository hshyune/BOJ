import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int k = Integer.parseInt(sp[1]);
		int[][] dp = new int[k + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[1][i] = 1;
		}

		for (int i = 1; i <= k; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		System.out.println(dp[k][n]);
	}

}
