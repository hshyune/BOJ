import java.io.*;

public class Main {

	static long f0 = 0;
	static long f1 = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				fib(num);
				System.out.println(f0 + " " + f1);
				f0 = 0;
				f1 = 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static long fib(int n) {
		if (n == 0) {
			f0++;
			return 0;
		}
		if (n == 1) {
			f1++;
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

}
