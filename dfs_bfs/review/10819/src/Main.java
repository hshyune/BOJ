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

		int max = getDiff(arr);
		while (permutation(arr)) {
			max = Math.max(max, getDiff(arr));
		}
		System.out.println(max);
	}

	public static boolean permutation(int[] arr) {
		int i = -1;
		for (int k = 1; k < arr.length; k++) {
			if (arr[k - 1] < arr[k]) {
				i = k;
			}
		}
		if (i == -1) {
			return false;
		}
		int j = -1;
		for (int k = i; k < arr.length; k++) {
			if (arr[i - 1] < arr[k]) {
				j = k;
			}
		}

		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;

		Arrays.sort(arr, i, arr.length);
		return true;
	}

	public static int getDiff(int[] arr) {
		int res = 0;
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			res += Math.abs(arr[i] - arr[i - 1]);
		}
		return res;
	}

}
