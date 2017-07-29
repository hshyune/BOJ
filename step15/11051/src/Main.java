import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String str = br.readLine();
			String[] sp = str.split(" ");
			int n = Integer.parseInt(sp[0]);
			int k = Integer.parseInt(sp[1]);
			long[][] arr = new long[1001][1001];
			arr[0][0] = 1;
			arr[1][0] = 1;
			arr[1][1] = 1;
			// nCk = n-1Ck-1+n-1Ck
			for (int i = 2; i <= n; i++) {
				arr[i][0] = 1;
				for (int j = 1; j <= k; j++) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					arr[i][j] %= 10007;
				}
			}
			System.out.println(arr[n][k]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
