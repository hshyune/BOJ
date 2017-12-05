import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		String[] sp = null;
		int M = 0;
		int N = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < tc; i++) {
			sp = br.readLine().split(" ");
			M = Integer.parseInt(sp[0]);
			N = Integer.parseInt(sp[1]);
			x = Integer.parseInt(sp[2]);
			y = Integer.parseInt(sp[3]);
			sb.append(solve(M, N, x, y) + "\n");
		}
		System.out.println(sb.toString());
		//System.out.println(solve(3, 5, 1, 5));
	}

	public static int solve(int M, int N, int x, int y) {
		int lcm = M * N / gcd(M, N);
		int n = 0;
		for (int i = 0; i * M < lcm; i++) {
			n = i * M + x;
			if (n % N == y) {
				return n;
			}
			if (n % N == 0 && y == N) {
				return n;
			}
		}
		return -1;
	}

	public static int gcd(int a, int b) {
		// a>b
		int mod = a % b;
		while (mod > 0) {
			a = b;
			b = mod;
			mod = a % b;
		}
		return b;
	}

}
