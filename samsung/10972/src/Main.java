import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis();
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in, 1);
			int n = Integer.parseInt(br.readLine());
			int k = 0;
			int j = 0;
			int[] arr = new int[n];
			String[] sp = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(sp[i]);
			}

			// find k
			for (int i = 0; i < n + 1; i++) {
				if (arr[i] < arr[i + 1]) {
					if (i > k) {
						k = i;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}