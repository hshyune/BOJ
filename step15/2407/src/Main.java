import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String[] sp = br.readLine().split(" ");
			int n = Integer.parseInt(sp[0]);
			int m = Integer.parseInt(sp[1]);
			
			BigInteger res = fact(n).divide(fact(m).multiply(fact(n-m)));
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BigInteger fact(int n) {
		BigInteger bi = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		return bi;
	}

}
