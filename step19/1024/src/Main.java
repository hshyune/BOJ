import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String[] sp = br.readLine().split(" ");
			int n = Integer.parseInt(sp[0]);
			int l = Integer.parseInt(sp[1]);
			if (n % 2 == 0) {
				if (l % 2 == 0) {
					l++;
					int[] res = new int[l];
					int mid = n / l;
					for (int i = 0; i < l; i++) {
						res[i] = mid - (l - i) + 1;
						System.out.println(res[i]);
					}

				}
			} else {

			}
		} catch (IOException e) {

		}
	}

}
