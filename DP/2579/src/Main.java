import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		long[] dp = new long[n];
		long max = Long.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = arr[0];
		for (int i = 1; i < 3; i++) {
			if (i == 1) {
				dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			} else {
				dp[i] = Math.max(dp[i - 2] + arr[i], arr[i - 1] + arr[i]);
			}

		}

		for (int i = 3; i < n; i++) {
			long case1 = dp[i - 2] + arr[i];
			long case2 = dp[i - 3] + arr[i] + arr[i - 1];
			dp[i] = Math.max(case1, case2);
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(dp[n - 1]);
	}

}
