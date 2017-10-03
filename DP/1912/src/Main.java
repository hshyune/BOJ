import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] sp = br.readLine().split(" ");
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sp[i]);
			dp[i] = Integer.MIN_VALUE;
		}

		dp[0] = arr[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
			max = Math.max(max, dp[i]);
		}
		max = Math.max(max, dp[0]);
		System.out.println(max);

	}

}
