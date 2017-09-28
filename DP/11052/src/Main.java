import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		int[] price = new int[n + 1];

		price[0] = 0;
		String[] sp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			price[i + 1] = Integer.parseInt(sp[i]);
		}

		for (int i = 1; i <= n; i++) {
			// dp[i] = 0;
			for (int j = 1; j <= n; j++) {
				if (j >= i) {
					if (price[i] + dp[j - i] < dp[j]) {
						dp[j] = dp[j];
					} else {
						dp[j] = price[i] + dp[j - i];
					}
				}
			}
		}
		System.out.println(dp[n]);
	}

}
