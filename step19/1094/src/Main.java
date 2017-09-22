import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int x = Integer.parseInt(br.readLine());
			int[] stick = new int[] { 64, 32, 16, 8, 4, 2, 1 };

			int res = 0;
			for (int i = 0; i < 7; i++) {
				if (x >= stick[i]) {
					int ea = x / stick[i];
					x = x - stick[i] * ea;
					res += ea;
				}
			}
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
