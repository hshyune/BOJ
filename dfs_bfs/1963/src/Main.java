import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		Password p = new Password();
		for (int i = 0; i < n; i++) {
			p.init();
			String[] sp = br.readLine().split(" ");
			System.out.println(p.bfs(Integer.parseInt(sp[0]), Integer.parseInt(sp[1])));
		}

	}
}

class Eratos {
	int[] arr = null;
	int era;
	int max;

	public Eratos(int n) {
		this.max = n;
		arr = new int[max];

		int i = 0;
		while (true) {
			if (i * i > max) {
				era = i;
				break;
			}
			i++;
		}
	}

	public void check() {
		for (int i = 2; i < era; i++) {
			for (int j = 2; j * i < max; j++) {
				arr[j * i] = -1;
			}
		}
	}

	public void print() {
		int cnt = 0;
		for (int i = 2; i < max; i++) {
			if (arr[i] != -1) {
				cnt++;
				System.out.print(i + " ");
				if (cnt % 10 == 0)
					System.out.println();
			}
		}
	}

	public boolean isPrime(int num) {
		if (arr[num] != -1) {
			return true;
		}
		return false;
	}
}

class Password {
	Queue<Integer> q = null;
	int[] visit = new int[10000];
	Eratos e;

	public Password() {
		q = new LinkedList<Integer>();
		e = new Eratos(10000);
		e.check();
	}

	public void init() {
		q.removeAll(q);
		Arrays.fill(visit, -1);
	}

	public int bfs(int cur, int cmp) {
		q.offer(cur);
		visit[cur] = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == cmp) {
				return visit[now];
			} else {
				for (int i = 0; i < 4; i++) {
					int[] arr_now = numToArr(now);
					for (int j = 0; j < 10; j++) {
						if (i != 0 || j != 0) {
							if (arr_now[i] != j) {
								arr_now[i] = j;
								int next = arrToNum(arr_now);
								if (visit[next] == -1 && isPrime(next)) {
									visit[next] = visit[now] + 1;
									q.offer(next);
								}
							}
						}
					}
				}
			}
		}
		return -1;
	}

	public int arrToNum(int[] arr) {
		int res = 0;
		res += arr[0] * 1000;
		res += arr[1] * 100;
		res += arr[2] * 10;
		res += arr[3];
		return res;
	}

	public int[] numToArr(int num) {
		int[] arr = new int[4];
		arr[0] = (num / 1000);
		arr[1] = (num / 100) % 10;
		arr[2] = (num / 10) % 10;
		arr[3] = num % 10;
		return arr;
	}

	public boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
