import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			
			while (true) {
				int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					System.exit(0);
				}
				int cnt = 0;
				for (int i = n + 1; i <= 2 * n; i++) {
					if (isPrime(i))
						cnt++;
				}
				System.out.println(cnt);
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
