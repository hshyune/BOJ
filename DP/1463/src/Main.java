import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] memo = new int[n + 1];
		if (n == 1) {
			System.out.println(0);
			System.exit(0);
		}
		if (n == 2 || n == 3) {
			System.out.println(1);
			System.exit(0);
		}
		memo[1] = 0;
		memo[2] = 1;
		memo[3] = 1;
		for (int i = 4; i <= n; i++) {
			memo[i] = memo[i - 1] + 1;
			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			}
			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			}
		}
	
		System.out.println(memo[n]);
	}

}
