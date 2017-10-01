import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] memo = new int[n];
		String[] sp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sp[i]);
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}
		int max = 0;
		int prev = 0;
		for (int i = 1; i < n; i++) {
			prev = 0;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					if(prev < arr[j]) {
						prev = arr[j];
						memo[i]++;
					}
				}
			}
			memo[i]++;
		}
		System.out.println(Arrays.toString(memo));
		System.out.println(max);
	}

}
