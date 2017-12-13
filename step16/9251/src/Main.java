import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int size1 = str1.length();
		int size2 = str2.length();
		int[][] arr = new int[size2 + 1][size1 + 1];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= size2; i++) {
			arr[i][0] = 0;
		}
		for (int i = 0; i <= size1; i++) {
			arr[0][i] = 0;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= size2; i++) {
			for (int j = 1; j <= size1; j++) {
				if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}
		int prev = 0;
		for (int i = 1; i <= size2; i++) {
			for (int j = 1; j < size1; j++) {
				if (prev < arr[i][j]) {
					sb.append(str1.charAt(i-1));
					prev = arr[i][j];
				}
			}
		}
		System.out.println(arr[size2][size1]);
		System.out.println(sb.toString());

	}

}
