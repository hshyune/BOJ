import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int subin = Integer.parseInt(sp[0]);
		int sister = Integer.parseInt(sp[1]);
		System.out.println(bfs(subin, sister));
	}

	public static int bfs(int subin, int sister) {
		int sec = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[100000 + 1];
		visit[subin] = sec;
		q.add(subin);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == sister) {
				sec = visit[now] - 1;
			} else {
				if ((now - 1) >= 0 && visit[now - 1] == 0) {
					visit[now - 1] = visit[now] + 1;
					q.add(now - 1);
				}
				if ((now + 1) <= 100000 && visit[now + 1] == 0) {
					visit[now + 1] = visit[now] + 1;
					q.add(now + 1);
				}
				if ((now * 2) <= 100000 && visit[now * 2] == 0) {
					visit[now * 2] = visit[now] + 1;
					q.add(now * 2);
				}
			}
		}
		return sec;
	}

}
