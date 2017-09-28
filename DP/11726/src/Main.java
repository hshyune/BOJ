import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		// 11726
		// if (n == 1) {
		// System.out.println(1);
		// return;
		// }
		// if (n == 2) {
		// System.out.println(2);
		// return;
		// }
		// int[] dp = new int[n + 1];
		// dp[0] = 1;
		// dp[1] = 1;
		// dp[2] = 2;
		// for (int i = 3; i <= n; i++) {
		// dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		// }
		// System.out.println(dp[n]);

		// 11727
		if (n == 1) {
			System.out.println(1);
			return;
		}
		if (n == 2) {
			System.out.println(3);
			return;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}
		System.out.println(dp[n]);

	}

}
