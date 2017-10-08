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
			for (int j = 0; j <= n; j++) {
				for (int l = 0; l <= j; l++) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % 1000000000;
				}
			}
		}
		// for (int i = 0; i <= k; i++) {
		// System.out.println(Arrays.toString(dp[i]));
		// }
		System.out.println(dp[k][n]);
	}

}
