package bdmj_1;

import java.util.*;

class Main {

	final static int FAILED = 0;

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			int d = s.nextInt();
			int k = s.nextInt();
			int j = s.nextInt();

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			int cur = 0;

			if (d == 0) {
				int cnt = 0;
				for (int remain = n; remain > 1; remain--) {
					while (true) {
						cur = Math.abs((cur + n - 1) % n);
						if (arr[cur] != FAILED) {
							cnt++;
						}
						if (cnt == k) {
							arr[cur] = FAILED;
							break;
						}
					}
					cnt = 0;
					k += j;
				}
			} else {
				int cnt = 0;
				for (int remain = n; remain > 1; remain--) {
					while (true) {
						cur = (cur + 1) % n;
						if (arr[cur] != FAILED) {
							cnt++;
						}
						if (cnt == k) {
							arr[cur] = FAILED;
							break;
						}
					}
					cnt = 0;
					k += j;
				}
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] != FAILED) {
					System.out.println(arr[i]);
					break;
				}
			}
		}
	}
}
