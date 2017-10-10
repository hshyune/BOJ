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

		if (prevPermutation(arr)) {
			// print
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println(-1);
		}

	}

	public static boolean prevPermutation(int[] arr) {
		int n = arr.length;

		// find i
		int i = n - 1;
		while (i > 0 && arr[i - 1] < arr[i]) {
			i -= 1;
		}
		if (i <= 0)
			return false;

		// find j
		int j = n - 1;
		while (arr[j] > arr[i - 1]) {
			j -= 1;
		}

		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;

		while (i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		return true;
	}

}
