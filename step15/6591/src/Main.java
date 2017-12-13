import java.io.*;
import java.util.Arrays;

public class Main {

	final static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp = null;
		while (true) {
			sp = br.readLine().split(" ");
			int n = Integer.parseInt(sp[0]);
			int m = Integer.parseInt(sp[1]);
			if (n == 0 && m == 0)
				break;
			System.out.println(nCr(n, m));
		}
	}

	public static long nCr(int n, int r) {
		if (r * 2 > n) {
			r = n - r;
		}
		if (n == r) {
			return 1;
		}
		if (r == 0) {
			return 1;
		}
		if (r == 1 || r == (n - 1)) {
			return n % MOD;
		}
		return nCr(n - 1, r) % MOD + nCr(n - 1, r - 1) % MOD;
	}

}
