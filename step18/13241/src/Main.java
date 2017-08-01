import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String[] sp = br.readLine().split(" ");

			int a = Integer.parseInt(sp[0]);
			int b = Integer.parseInt(sp[1]);
			long res = gcd(a, b);
			System.out.println(res * (a / res) * (b / res));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static long gcd(int a, int b) {
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
