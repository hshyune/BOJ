import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			System.out.println(fact(n));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * fact(n - 1);
	}

}
