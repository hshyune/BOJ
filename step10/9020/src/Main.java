import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				int sub = 10000;
				int p1 = 0;
				for (int j = 2; j <= num / 2; j++) {
					if (isPrime(j) && isPrime(num - j)) {
						if (sub > Math.abs(num - 2 * j)) {
							p1 = j;
						}
					}
				}
				System.out.println(Math.min(p1, num - p1) + " " + Math.max(p1, num - p1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isPrime(int num) {
		if (num == 1)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;

		for (int i = 3; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;

	}
}
