import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BigInteger bi = new BigInteger(br.readLine());
			int n = Integer.parseInt(bi.mod(new BigInteger("1500000")).toString());
			
			int mod = 1000000;
			int period = mod / 10 * 15;

			long[] fib = new long[period + 1];
			fib[0] = 0;
			fib[1] = 1;
			for (int i = 2; i <= period; i++) {
				fib[i] = fib[i - 2] + fib[i - 1];
				fib[i] %= mod;
			}
			System.out.println(fib[n]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
