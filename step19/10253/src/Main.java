import java.io.*;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int loop = 0; loop < tc; loop++) {
			String[] sp = br.readLine().split(" ");
			int a = Integer.parseInt(sp[0]);
			int b = Integer.parseInt(sp[1]);
			int x = 1;
			while (a != 1) {
				if (a % b == 0) {
					x = b / a;
				} else {
					x = b / a + 1;
				}
				a = a * x - b;
				b = b * x;
				int g = gcd(a, b);
				a /= g;
				b /= g;
			}
			sb.append(b + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int gcd(int a, int b) {
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}

}
