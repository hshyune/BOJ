import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		String[] sp = br.readLine().split(" ");
		int[] dp = new int[n + 1];
		int[] ndp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(sp[i - 1]);
		}

		int res = 0;
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if (arr[i] > arr[j]) {
					if (max < dp[j]) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			Math.max(dp[i], max);
		}

		for (int i = n; i >= 0; i--) {
			int max = 0;
			for (int j = n; j >= i; j--) {
				if (arr[i] > arr[j]) {
					if (max < ndp[j]) {
						max = ndp[j];
					}
				}
			}
			ndp[i] = max+1;
			Math.max(ndp[i], max);
		}
		for (int i = 1; i <= n; i++) {
			res = Math.max(res, ndp[i]+dp[i]-1);
		}

		System.out.println(res);
	}

}
