import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);

		Puzzle p = new Puzzle();
		String target = "";
		for (int i = 0; i < 3; i++) {
			String[] sp = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				target += sp[j];
			}
		}
		p.init(target);
		System.out.println(p.bfs());
	}

}

class Puzzle {
	String init;
	Queue<String> q;
	String cmp = "123456780";
	HashMap<String, Integer> visit;
	int cnt;
	int[] vRow = { -1, 0, 1, 0 };
	int[] vCol = { 0, 1, 0, -1 };
	int[] vPoint = { -3, 1, 3, -1 };

	public void init(String str) {
		q = new LinkedList<String>();
		visit = new HashMap<String, Integer>();
		cnt = 0;
		this.init = str;
	}

	public int bfs() {
		String now = init;
		q.offer(init);
		visit.put(init, 0);

		while (!q.isEmpty()) {
			now = q.poll();

			if (cmp.equals(now)) {
				return visit.get(now);
			} else {

				int point = 0;
				// find '0' point
				for (int i = 0; i < 9; i++) {
					if (now.charAt(i) == '0') {
						point = i;
					}
				}

				for (int dir = 0; dir < 4; dir++) {
					// N E S W

					int nPoint = point + vPoint[dir];
					if (nPoint < 0 || nPoint > 8)
						continue;

					char[] next = now.toCharArray();
					char tmp = next[point];
					next[point] = next[nPoint];
					next[nPoint] = tmp;

					String nextState = String.valueOf(next);
					boolean flag = true;
					for (Map.Entry<String, Integer> key : visit.entrySet()) {
						if (key.getKey().equals(nextState)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						visit.put(nextState, visit.get(now) + 1);
						q.offer(nextState);
					}
				}
			}
		}
		return -1;
	}
}
