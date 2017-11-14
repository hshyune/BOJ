import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] room = new int[1000001];
		String[] sp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			room[i] = Integer.parseInt(sp[i]);
		}
		sp = br.readLine().split(" ");
		int b = Integer.parseInt(sp[0]);
		int c = Integer.parseInt(sp[1]);

		long man = 0;
		for (int i = 0; i < n; i++) {
			room[i] -= b;
			man++;

			if (room[i] > 0) {
				if (room[i] % c == 0) {
					man += room[i] / c;
				} else {
					man += room[i] / c;
					man += 1;
				}
			}
		}
		System.out.println(man);

	}

}
