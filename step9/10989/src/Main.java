import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int[] arr = new int[10001];
		int size = Integer.parseInt(br.readLine());
		for (int loop = 0; loop < size; loop++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[tmp]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int loop = 1; loop < 10001; loop++) {
			if (arr[loop] != 0) {
				for (int i = 0; i < arr[loop]; i++) {
					sb.append(loop + "\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
