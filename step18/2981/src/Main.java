import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		long[] diff = new long[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diff[i] = arr[i + 1] - arr[i];
		}
		Arrays.sort(diff);

		long gcd = diff[0];
		for (int i = 1; i < N - 1; i++) {
			gcd = gcd(gcd, diff[i]);
		}
		System.out.println(div(gcd));
	}

	public static long gcd(long a, long b) {
		long big = Math.max(a, b);
		long small = Math.min(a, b);
		if (big % small == 0)
			return small;
		return gcd(small, big % small);
	}

	public static String div(long num) {
		LinkedList<Long> list = new LinkedList<Long>();
		int sqrt = (int) Math.sqrt(num);
		for (long i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				list.add(i);
				if (i * i != num) {
					list.add(num / i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		list.removeFirst();
		for (Long n : list) {
			sb.append(n + " ");
		}
		return sb.toString();
	}

}
