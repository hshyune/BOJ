import java.io.*;
import java.util.*;

public class Main {

	static LinkedList<Long> list = new LinkedList<Long>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		list = new LinkedList<Long>();
		div(arr[n - 1] - arr[0], list);

		StringBuilder sb = new StringBuilder();
		for (Long num : list) {
			boolean flag = true;
			long mod = arr[0] % num;
			for (int i = 0; i < n; i++) {
				if (arr[i] % num != mod) {
					flag = false;
					break;
				}
			}
			if (flag) {
				sb.append(num + " ");
			}
		}
		System.out.println(sb.toString());

	}

	public static void div(long num, LinkedList<Long> list) {
		long sqrt = (long) Math.sqrt(num);
		for (long i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				list.add(i);
				if (i != sqrt) {
					list.add(num / i);
				}
			}
		}
		Collections.sort(list);
		list.removeFirst();
	}

}
