import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);

		int n = Integer.parseInt(br.readLine());
		String[] sp = br.readLine().split(" ");
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(sp[i - 1]);
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			sp = br.readLine().split(" ");
			int start = Integer.parseInt(sp[0]);
			int end = Integer.parseInt(sp[1]);
			System.out.println(isPalindrome(arr, start, end));
		}

	}

	public static int isPalindrome(int[] arr, int start, int end) {
		int size = (end - start + 1) / 2;

		for (int i = 0; i < size; i++) {
			if (arr[start + i] != arr[end - i]) {
				return 0;
			}
		}
		return 1;
	}
}
