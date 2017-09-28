import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] sp = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(sp[i]);
			}
			Arrays.sort(arr);
			Permu p = new Permu();
			p.permu(arr, 0, n, n);
			System.out.println(p.getMax());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Permu {
	private int max = 0;

	public void rotateRight(int[] arr, int start, int end) {
		int last = arr[end];
		for (int i = end; i > start; i--) {
			arr[i] = arr[i - 1];
		}
		arr[start] = last;
	}

	public void rotateLeft(int[] arr, int start, int end) {
		int first = arr[start];
		for (int i = start; i < end; i++) {
			arr[i] = arr[i + 1];
		}
		arr[end] = first;
	}

	public void permu(int[] arr, int depth, int n, int k) throws IOException {
		if (depth == k) {
			// do it
			setMaxDiff(arr);
			return;
		}
		for (int i = depth; i < n; i++) {
			rotateRight(arr, depth, i);
			permu(arr, depth + 1, n, k);
			rotateLeft(arr, depth, i);
		}
	}

	public void setMaxDiff(int[] arr) {
		int size = arr.length;
		int tmp = 0;
		for (int i = 0; i < size - 1; i++) {
			tmp = tmp + Math.abs(arr[i] - arr[i + 1]);
		}
		if (this.max < tmp)
			max = tmp;
	}

	public int getMax() {
		return this.max;
	}
}
