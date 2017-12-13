import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int loop = 0; loop < tc; loop++) {
			int size = Integer.parseInt(br.readLine());
			String[] sp = br.readLine().split(" ");
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(sp[i]);
			}
			int[][] dp = new int[size][size];
			for (int i = 0; i < size; i++) {
				dp[i][i] = arr[i];
				for (int j = i + 1; j < size; j++) {
					dp[i][j] = Math.min(dp[i][j - 1] + arr[i], dp[i + 1][j] + arr[i]);
					int sum = 0;
					for(int begin = i;begin<=j;begin++) {
						sum+=arr[begin];
					}
					//dp[i][j] += sum;
				}
			}
			for (int i = 0; i < size; i++) {
				System.out.println(Arrays.toString(dp[i]));
			}
		}

	}

}
