import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][10];

		// init
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				// init
				dp[i][j] = 0;

				//
				if (j - 1 >= 0) {
					dp[i][j] += dp[i - 1][j - 1];
				}
				if (j + 1 <= 9) {
					dp[i][j] += dp[i - 1][j + 1];
				}
				dp[i][j] %= 1000000000;

			}
		}

		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum % 1000000000);
	}

}
