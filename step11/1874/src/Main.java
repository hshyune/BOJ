import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Integer> s = new Stack<Integer>();
		int num = 0;
		s.push(num++);
		for (int loop = 0; loop < size; loop++) {
			int now = Integer.parseInt(br.readLine());
			if (s.peek() < now) {
				while (num <= now) {
					s.push(num++);
					sb.append("+\n");
				}
			}
			if (s.peek() == now) {
				sb.append("-\n");
				s.pop();
				continue;
			}
			if (s.peek() > now) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println(sb.toString());
	}

}
