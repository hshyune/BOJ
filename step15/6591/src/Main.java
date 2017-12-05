import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MAX = 50;
		int[][] arr = new int[MAX + 1][MAX + 1];
		arr[1][0] = 1;
		arr[1][1] = 1;
		for (int i = 2; i <= MAX; i++) {
			arr[i][0] = 1;
			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
			arr[i][i] = 1;
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
