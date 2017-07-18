import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] data = new int[n + 1];
			data[0] = 0;
			data[2] = 0;

			for (int i = 2; i <= m; i++) {
				if (data[i] != 1)
					data[i] = 0;
				for (int j = 2; j * i <= n; j++) {
					data[j * i] = 1;
				}

			}

			for (int i = m; i <= n; i++) {
				if (data[i] == 0)
					System.out.println(i);
			}

		} catch (

		IOException e) {
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
