import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String buf = br.readLine();
			String[] sp = buf.split(" ");
			int n = Integer.parseInt(sp[0]);
			int m = Integer.parseInt(sp[1]);
			ArrayList<Integer> q = new ArrayList<Integer>();

			for (int i = 1; i <= n; i++) {
				q.add(i);
			}

			int cnt = 1;
			System.out.print("<");
			while (!q.isEmpty()) {
				if (cnt != m) {
					q.add(q.remove(0));
					cnt++;
				} else {
					cnt = 1;
					if (q.size() == 1) {
						System.out.print(q.remove(0));
						break;
					} else {
						System.out.print(q.remove(0) + ", ");
					}
				}
			}
			System.out.println(">");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
