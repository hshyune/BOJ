package line_2;

import java.util.Scanner;

public class Main {
	/*
	 * Description : Time complexity : Space complexity :
	 */
	public int calc(long n) {
		// TODO : implement your codes to here.
		int cnt = 0;
		int sqrt = (int) Math.sqrt(n);

		for (int i = 1; i < sqrt; i++) {
			if (n % i == 0) {
				cnt++;
			}
		}
		cnt *= 2;
		if (sqrt * sqrt == n)
			cnt++;
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();

		Scanner scanner = new Scanner(System.in);

		long n = scanner.nextLong();

		System.out.println(main.calc(n));

		scanner.close();
	}
}