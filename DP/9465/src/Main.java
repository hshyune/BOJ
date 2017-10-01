import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][n + 1];
			int[][] cost = new int[2][n + 1];

			String[] sp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				cost[0][j] = Integer.parseInt(sp[j - 1]);
			}

			sp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				cost[1][j] = Integer.parseInt(sp[j - 1]);
			}

			for (int j = 0; j <= n; j++) {
				dp[0][j] = Math.max(getValue(dp, 1, j - 1), getValue(dp, 1, j - 2)) + cost[0][j];
				dp[1][j] = Math.max(getValue(dp, 0, j - 1), getValue(dp, 0, j - 2)) + cost[1][j];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

	public static int getValue(int[][] arr, int row, int col) {
		if (col <= 0) {
			return 0;
		}
		return arr[row][col];
	}

}
