import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			long n = Integer.parseInt(br.readLine());
			String str = fact(n).toString(10);
			int size = str.length();
			int cnt = 0;
			for (int i = size - 1; i >= 0; i--) {
				if (str.charAt(i) == '0')
					cnt++;
				else
					break;
			}
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BigInteger fact(long n) {
		if (n == 0 || n == 1)
			return BigInteger.ONE;
		BigInteger bi = BigInteger.ONE;
		for (long i = 1; i <= n; i++) {
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		return bi;
	}

}
