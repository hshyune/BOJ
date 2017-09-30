import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		String[] sp = br.readLine().split(" ");
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(sp[i-1]);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			int prev = -1;
			for (int j = 0; j <= i; j++) {
				if (arr[i] > arr[j]) {
					if (prev < dp[j]) {
						prev = dp[j];
					}
				}
			}
			dp[i] += arr[i] + prev;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
