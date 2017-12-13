import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		Boolean[] isJaegob = new Boolean[1000002];
		for (int i = 0; i < 1000002; ++i)
			isJaegob[i] = false;
		long end = (long) Math.sqrt(b);
		for (long i = 2; i <= end; ++i) {
			long k = i * i;
			long start = ((a - 1) / k + 1) * k;
			for (long j = start; j <= b; j += k)
				isJaegob[(int) (j - a)] = true;
		}
		int sz = (int) (b - a + 1);
		int ans = 0;
		for (int i = 0; i < sz; ++i)
			ans += (isJaegob[i] == true) ? 1 : 0;
		System.out.print(sz - ans);
	}
}