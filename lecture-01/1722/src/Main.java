import java.io.*;
import java.util.Arrays;
import java.util.BitSet;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(out);
		PrintWriter pw = new PrintWriter(bw);

		int n = Integer.parseInt(br.readLine());
		String[] sp = br.readLine().split(" ");
		int m = Integer.parseInt(sp[0]);

		long[] fact = new long[n];
		fact[0] = 1;

		for (int i = 1; i < n; i++) {
			fact[i] = fact[i - 1] * (i);
		}

		if (m == 1) {
			// get permutation
			long order = Long.parseLong(sp[1]);
			BitSet bit = new BitSet(n);
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				int tmp = 0;
				for (int j = 0; j < n; j++) {
					if (bit.get(j))
						continue;
					if (fact[n - 1 - i] < order) {
						order -= fact[n - i - 1];
					} else {
						arr[i] = j + 1;
						bit.set(j);
						break;
					}
				}
			}
			for (int i = 0; i < n - 1; i++) {
				pw.print(arr[i] + " ");
			}
			pw.println(arr[n - 1]);
		}
		if (m == 2) {
			// get order
			int[] cmp = new int[n];
			for (int i = 0; i < n; i++) {
				cmp[i] = Integer.parseInt(sp[i + 1]);
			}
			BitSet bit = new BitSet(n);

			long cnt = 1;
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < cmp[i] - 1; j++) {
					if (!bit.get(j)) {
						cnt += fact[n - 1 - i];
					}
				}
				bit.set(cmp[i] - 1);
			}
			pw.println(cnt);
		}
		br.close();
		pw.close();
	}

}
