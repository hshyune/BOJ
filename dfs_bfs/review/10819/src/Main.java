import java.io.*;
import java.util.Arrays;

public class Main {

	int maxDiff = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] sp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sp[i]);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		while (permutation(arr)) {

		}

	}

	public static boolean permutation(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i -= 1;
		}
		if (i <= 0) {
			return false;
		}
		int j = arr.length - 1;
		while (arr[i - 1] >= arr[j]) {
			j -= 1;
		}

		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;

		while (i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i += 1;
			j -= 1;
		}
		System.out.println(Arrays.toString(arr));
		return true;
	}

}
