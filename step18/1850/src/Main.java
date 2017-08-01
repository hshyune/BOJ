import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String[] sp = br.readLine().split(" ");
			long a = Long.parseLong(sp[0]);
			long b = Long.parseLong(sp[1]);
			long res = gcd(a, b);

			for (int i = 0; i < res; i++) {
				System.out.print("1");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static long gcd(long a, long b) {
		if (a == 0)
			return b;
		while (b > 0) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

}
