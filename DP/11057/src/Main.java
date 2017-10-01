import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		Ascend asd = new Ascend(n);
		System.out.println(asd.getAscend());
	}

}

class Ascend {
	private int[][] arr;
	private int size;

	public Ascend(int n) {
		this.size = n;
		arr = new int[n + 1][10];
		for (int i = 0; i < 10; i++) {
			arr[0][i] = 0;
			arr[1][i] = 1;
		}
	}

	public int getAscend() {
		if (size > 1) {
			for (int i = 2; i <= size; i++) {
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k <= j; k++) {
						arr[i][j] = (arr[i][j] + arr[i - 1][k]) % 10007;
					}
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + arr[size][i]) % 10007;
		}
		return (int) (sum % 10007);
	}
}
