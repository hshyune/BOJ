import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - j * j] + 1 || dp[i] == 0) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		System.out.println(dp[n]);
	}

}
