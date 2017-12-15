import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] sp = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sp[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n; i++) {
			int gcd = gcd(arr[0], arr[i]);
			sb.append((arr[0] / gcd) + "/" + (arr[i] / gcd) + "\n");
		}
		System.out.println(sb.toString());

	}

	public static int gcd(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		if (big % small == 0) {
			return small;
		}
		return gcd(small, big % small);
	}

}
