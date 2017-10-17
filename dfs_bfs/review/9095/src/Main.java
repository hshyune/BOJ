import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		int[] dp = new int[11 + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 11; i++) {
			dp[i] += (dp[i - 1] + dp[i - 2] + dp[i - 3]);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PrintWriter pw = new PrintWriter(bw);
		for (int i = 0; i < n; i++) {
			pw.println(dp[arr[i]]);
		}
		pw.close();
	}

}
