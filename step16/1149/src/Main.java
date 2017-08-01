import java.io.*;
import java.util.Arrays;

public class Main {

	static int pre = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			long sum = 0;
			int min = 1001;
			for (int i = 0; i < n; i++) {
				String[] sp = br.readLine().split(" ");
				int[] rgb = new int[3];
				rgb[0] = Integer.parseInt(sp[0]);
				rgb[1] = Integer.parseInt(sp[1]);
				rgb[2] = Integer.parseInt(sp[2]);

				int tmp = getMin(rgb);
				sum += tmp;
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getMin(int[] arr) {
		int min = 9999;
		for (int i = 0; i < 3; i++) {
			if (i != pre) {
				if (min >= arr[i]) {
					min = arr[i];
					pre = i;
				}
			}
		}
		return min;
	}

}
