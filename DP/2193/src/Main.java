import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		// exception
		if (n == 1 || n == 2) {
			System.out.println(1);
			return;
		} else {
			dp[1] = 1;
			dp[2] = 1;
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		System.out.println(dp[n]);
	}

}
