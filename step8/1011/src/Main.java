import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		int tc = Integer.parseInt(br.readLine());
		String[] sp = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			sp = br.readLine().split(" ");
			long dist = Long.parseLong(sp[1]) - Long.parseLong(sp[0]);
			dist = Math.abs(dist);
			sb.append(solve(dist) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static long solve(long dist) {
		long n = findN(dist);
		long front = n * n;
		if (front == dist) {
			return 2 * n - 1;
		}
		long end = (n + 1) * (n + 1);
		long mid = end - n;

		if (front <= dist && dist < mid) {
			return 2 * n;
		} else {
			return 2 * n + 1;
		}
	}

	public static long findN(long dist) {
		long i = (long) Math.sqrt(dist);
		return i;
	}
}
