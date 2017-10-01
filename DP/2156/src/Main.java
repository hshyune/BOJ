import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());

		int[] wine = new int[n + 1];
		long[] dp = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		if (n == 1) {
			System.out.println(wine[1]);
			return;
		}
		if (n == 2) {
			System.out.println(wine[1] + wine[2]);
			return;
		}

		long max = 0;
		dp[1] = wine[1];
		dp[2] = dp[1] + wine[2];

		for (int i = 3; i <= n; i++) {
			// ....x
			long case1 = dp[i - 1];
			// ...xo
			long case2 = wine[i] + dp[i - 2];
			// ..xoo
			long case3 = wine[i] + wine[i - 1] + dp[i - 3];
			dp[i] = Math.max(Math.max(case1, case2), case3);
			max = Math.max(dp[i], dp[i - 1]);
		}
		System.out.println(max);
	}

}
