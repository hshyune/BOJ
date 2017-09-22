import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int pre = 0;
			for (int i = 1; i <= n; i++) {
				int[] arr = new int[i];
				String[] sp = br.readLine().split(" ");
				for (int j = 0; j < i; j++) {
					arr[j] = Integer.parseInt(sp[j]);
				}

				int[] tmp = getMax(arr, pre);
				sum += tmp[0];
				pre = tmp[1];
				System.out.println(tmp[0] + " " + tmp[1]);
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[] getMax(int[] arr, int pre) {
		int[] res = new int[2];
		if (arr.length == 1) {
			res[0] = arr[0];
			res[1] = 0;
		} else {
			if (arr[pre] > arr[pre + 1]) {
				res[0] = arr[pre];
				res[1] = pre;
			} else {
				res[0] = arr[pre + 1];
				res[1] = pre + 1;
			}
		}
		return res;
	}

}
