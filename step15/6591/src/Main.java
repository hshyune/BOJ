import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);

			while (true) {
				String[] sp = br.readLine().split(" ");
				int n = Integer.parseInt(sp[0]);
				int m = Integer.parseInt(sp[1]);
				if (n == 0 && m == 0)
					System.exit(0);
				long res = fact(n) / (fact(m) * fact(n - m));
				System.out.println(res);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static long fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return fact(n - 1) * n;
	}

}
