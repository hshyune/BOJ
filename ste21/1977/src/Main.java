import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int min = (int) Math.sqrt(M);
		int max = (int) Math.sqrt(N);

		if (min * min < M) {
			min += 1;
		}

		long sum = 0;
		for (int i = min; i <= max; i++) {
			sum += (i * i);
		}
		if (sum == 0) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(sum);
		System.out.println(min * min);
	}

}
