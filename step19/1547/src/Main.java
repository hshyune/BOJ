import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int answer = 1;
		for (int loop = 0; loop < tc; loop++) {
			String[] sp = br.readLine().split(" ");
			int a = Integer.parseInt(sp[0]);
			int b = Integer.parseInt(sp[1]);
			if (a == answer) {
				answer = b;
			} else if (b == answer) {
				answer = a;
			}
		}
		System.out.println(answer);
	}

}
