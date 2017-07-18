import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			int[] data = new int[n];
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(st.nextToken());
				if (isPrime(data[i]))
					cnt++;
			}
			System.out.println(cnt);

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
