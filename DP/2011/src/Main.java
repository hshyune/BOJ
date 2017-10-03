import java.io.*;
import java.util.Arrays;

public class Main {

	final static int A = 10;
	final static int Z = 26;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String str = br.readLine();
		int size = str.length();

		int[] dp = new int[size + 1];
		dp[0] = 1;

		for (int i = 1; i <= size; i++) {
			int last = str.charAt(i - 1) - '0';
			if (last != 0) {
				dp[i] = (dp[i] + dp[i - 1]) % 1000000;
			}
			if (i >= 2) {
				int last_2 = Integer.parseInt(str.substring(i - 2, i));
				if (isInbound(last_2)) {
					dp[i] = (dp[i] + dp[i - 2]) % 1000000;
				}
			}
		}
		System.out.println(dp[size]);
	}

	public static boolean isInbound(int num) {
		if (A <= num && num <= Z) {
			return true;
		}
		return false;
	}

}
