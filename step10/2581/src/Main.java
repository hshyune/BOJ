import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int min = 0;

			for (int i = m; i <= n; i++) {
				if (isPrime(i)) {
					sum += i;
					if (min == 0)
						min = i;
				}
			}
			if (sum == 0) {
				sum = -1;
				System.out.println(sum);
				System.exit(0);
			}
			System.out.println(sum);
			System.out.println(min);
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
