import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		String[] sp = null;
		int[] dp = new int[n + 1];
		int[] day = new int[n + 1];
		int[] pay = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			sp = br.readLine().split(" ");
			day[i] = Integer.parseInt(sp[0]);
			pay[i] = Integer.parseInt(sp[1]);
			dp[i] = pay[i];
		}

		int max = 0;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (i >= day[j] + j) {
					dp[i] = Math.max(pay[i] + dp[j], dp[i]);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (i + day[i] - 1 > n)
				dp[i] = 0;
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
