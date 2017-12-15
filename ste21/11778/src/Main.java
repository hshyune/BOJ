import java.io.*;
import java.util.Arrays;

public class Main {

	static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int m = Integer.parseInt(sp[1]);

		long[][] f1 = { { 1, 1 }, { 1, 0 } };
		long fn = (pow(f1, n)[0][1]) % MOD;
		long fm = (pow(f1, m)[0][1]) % MOD;
		System.out.println(gcd(Math.max(fn, fm), Math.min(fn, fm)));
	}

	public static long gcd(long a, long b) {
		long mod = a % b;
		while (mod > 0) {
			a = b;
			b = mod;
			mod = a % b;
		}
		return b;
	}

	public static long[][] mul(long[][] a, long[][] b) {
		long[][] res = new long[2][2];
		res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
		res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
		res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
		res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
		return res;
	}

	public static long[][] pow(long[][] a, int n) {
		long[][] res = { { 1, 0 }, { 0, 1 } };
		while (n > 0) {
			if (n % 2 == 1) {
				res = mul(res, a);
			}
			n /= 2;
			a = mul(a, a);
		}
		return res;
	}

}
