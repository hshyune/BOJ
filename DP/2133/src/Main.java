import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[31];
		if (n % 2 != 0) {
			System.out.println(0);
			return;
		}
		Arrays.fill(dp, 2);
		dp[0] = 1;
		dp[2] = 3;

		for (int i = 4; i <= 30; i = i + 2) {
			dp[i] = 3 * dp[i - 2];
			for (int j = 4; j <= i; j = j + 2) {
				dp[i] += 2 * dp[i - j];
			}
		}
		System.out.println(dp[n]);
	}

}
