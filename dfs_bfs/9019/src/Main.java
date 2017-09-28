import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);

		int n = Integer.parseInt(br.readLine());
		DSLR dslr = new DSLR();

		for (int i = 0; i < n; i++) {
			String[] sp = br.readLine().split(" ");
			dslr.init();
			System.out.println(dslr.bfs(Integer.parseInt(sp[0]), Integer.parseInt(sp[1])));
		}

	}

}

class DSLR {
	Queue<Register> q = new LinkedList<Register>();
	int cnt, min;
	boolean[] visit;

	public void init() {
		q.removeAll(q);
		cnt = 0;
		min = 999999999;
		visit = new boolean[10001];
	}

	public String bfs(int cur, int cmp) {
		q.offer(new Register(cur, ""));
		visit[cur] = true;
		while (!q.isEmpty()) {
			Register now = q.poll();
			if (now.num == cmp) {
				return now.cmd;
			}
			// case D S L R
			if (!visit[D(now.num)]) {
				int num = D(now.num);
				visit[num] = true;
				q.offer(new Register(num, now.cmd + "D"));
			}
			if (!visit[S(now.num)]) {
				int num = S(now.num);
				visit[num] = true;
				q.offer(new Register(num, now.cmd + "S"));
			}
			if (!visit[L(now.num)]) {
				int num = L(now.num);
				visit[num] = true;
				q.offer(new Register(num, now.cmd + "L"));
			}
			if (!visit[R(now.num)]) {
				int num = R(now.num);
				visit[num] = true;
				q.offer(new Register(num, now.cmd + "R"));
			}
		}
		return null;
	}

	public int D(int num) {
		return (num * 2) % 10000;
	}

	public int S(int num) {
		if (num == 0) {
			return 9999;
		} else {
			return num - 1;
		}
	}

	public int L(int num) {
		// rotate Left
		return (((num / 100) % 10) * 1000) + (((num / 10) % 10) * 100) + (((num) % 10) * 10) + (((num / 1000) % 10));
	}

	public int R(int num) {
		// rotate Right
		return ((num % 10) * 1000) + ((num / 1000) * 100) + (((num / 100) % 10) * 10) + (((num / 10) % 10));
	}
}

class Register {
	int num;
	String cmd;

	public Register(int num, String cmd) {
		this.num = num;
		this.cmd = cmd;
	}
}
