import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] sp = br.readLine().split(" ");

				int a = Integer.parseInt(sp[0]);
				int b = Integer.parseInt(sp[1]);
				int min = Math.min(a, b);
				int max = Math.max(a, b);
				
				long res = (min*max)/gcd(min,max);
				System.out.println(res);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static long gcd(int a, int b) {
		if (a == 0)
			return b;
		while (b != 0) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

}
