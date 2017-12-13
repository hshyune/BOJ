import java.io.*;
import java.util.Arrays;

public class Main {

	final static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] fac = new long[4000001];
		long[] inv = new long[4000001];
		fac[0] = 1;
		for (int i = 1; i <= 4000000; i++) {
			fac[i] = (i * fac[i - 1]) % MOD;
		}
		inv[4000000] = power(fac[4000000], MOD - 2);

		for (int i = 4000000 - 1; i > 0; i--) {
			inv[i] = (inv[i + 1] * (i + 1)) % MOD;
		}

		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int r = Integer.parseInt(sp[1]);
		System.out.println(nCr(n, r, fac, inv));

	}

	public static long nCr(int n, int r, long[] fac, long[] inv) {
		if (r == 0 || r == n)
			return 1;
		if (r * 2 > n)
			r = n - r;

		long tmp = (fac[n] * inv[r]) % MOD;
		return (tmp * inv[n - r]) % MOD;
	}

	public static long power(long base, long exp) {
		long res = 1;
		while (exp > 0) {
			if (exp % 2 == 1) {
				res *= base;
				res %= MOD;
			}
			base *= base;
			base %= MOD;
			exp /= 2;
		}
		return res;
	}

}
