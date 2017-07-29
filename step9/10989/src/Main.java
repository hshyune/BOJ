import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			int max = 10000;
			int[] data = new int[n];
			int[] tmp = new int[n];
			int[] cnt = new int[max + 1];
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(br.readLine());
				cnt[data[i]]++;
			}
			for (int i = 1; i <= max; i++) {
				cnt[i] = cnt[i - 1] + cnt[i];
			}
			for (int i = 0; i < n; i++) {
				tmp[--cnt[data[i]]] = data[i];
			}
			for (int i = 0; i < n; i++) {
				System.out.println(tmp[i]);
			}
		} catch (IOException e) {

		}
	}

}
