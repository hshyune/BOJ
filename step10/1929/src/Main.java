import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] data = new int[n + 1];
			data[0] = 1;
			data[1] = 1;

			for (int i = 2; i <= n; i++) {
				if (data[i] != 1)
					data[i] = 0;
				for (int j = 2; i * j <= n; j++) {
					data[i * j] = 1;
				}
			}
			for (int i = m; i <= n; i++) {
				if (data[i] == 0) {
					System.out.println(i);
				}
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

}
