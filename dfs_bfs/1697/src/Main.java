import java.io.*;
import java.util.*;

public class Main {

	static PrintWriter pw = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		pw = new PrintWriter(System.out);
		String[] sp = br.readLine().split(" ");
		int subin = Integer.parseInt(sp[0]);
		int sister = Integer.parseInt(sp[1]);
		bfs(subin, sister);
		pw.flush();
		pw.close();
		br.close();

	}

	public static void bfs(int subin, int sister) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[100001];
		visit[subin] = 1;
		q.add(subin);

		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == sister) {
				pw.println(visit[x] - 1);
			} else {
				if (x - 1 >= 0 && visit[x - 1] == 0) {
					visit[x - 1] = visit[x] + 1;
					q.add(x - 1);
				}
				if (x + 1 <= 100000 && visit[x + 1] == 0) {
					visit[x + 1] = visit[x] + 1;
					q.add(x + 1);
				}
				if (x * 2 <= 100000 && visit[x * 2] == 0) {
					visit[x * 2] = visit[x] + 1;
					q.add(x * 2);
				}
			}
		}
	}

}
