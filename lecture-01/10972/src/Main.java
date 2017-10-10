import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] sp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sp[i]);
		}

		// find i
		int idx_i = -1;
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i])
				idx_i = i;
		}
		if (idx_i == -1) {
			System.out.println(-1);
			return;
		}

		// find j
		int idx_j = -1;
		for (int i = idx_i; i < n; i++) {
			if (arr[idx_i - 1] < arr[i])
				idx_j = i;
		}

		// swap i,j
		int tmp = arr[idx_i - 1];
		arr[idx_i - 1] = arr[idx_j];
		arr[idx_j] = tmp;

		Arrays.sort(arr, idx_i, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
