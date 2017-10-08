import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int k = Integer.parseInt(sp[1]);
		int[] coin = new int[n + 1];
		int[] dp = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		for (int i = 1; i <= k; i++) {
			dp[i] = Integer.MAX_VALUE;

			for (int j = 1; j <= n; j++) {
				if (i - coin[j] >= 0 && dp[i - coin[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
				}
			}
		}
		if (dp[k] != Integer.MAX_VALUE) {
			System.out.println(dp[k]);
		} else {
			System.out.println(-1);
		}
	}

}
