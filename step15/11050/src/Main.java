import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String buf = br.readLine();
			String[] sp = buf.split(" ");
			int n = Integer.parseInt(sp[0]);
			int r = Integer.parseInt(sp[1]);
			long res = factorial(n) / (factorial(r) * factorial(n - r));
			System.out.println(res % 10007);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static long factorial(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

}
