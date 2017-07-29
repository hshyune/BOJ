import java.io.*;
import java.util.*;

public class Main {

	static int v;
	static int e;
	static int[][] ad;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String buf = br.readLine();
			String[] tmp = buf.split(" ");
			v = Integer.parseInt(tmp[0]);
			e = Integer.parseInt(tmp[1]);
			int start = Integer.parseInt(tmp[2]);
			ad = new int[v + 1][v + 1];
			visit = new boolean[v + 1];

			for (int i = 0; i < e; i++) {
				buf = br.readLine();
				tmp = buf.split(" ");
				int row = Integer.parseInt(tmp[0]);
				int col = Integer.parseInt(tmp[1]);
				ad[row][col] = 1;
				ad[col][row] = 1;
			}

			dfs(start);
			System.out.println();

			for (int i = 0; i < v + 1; i++) {
				visit[i] = false;
			}
			bfs(start);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void dfs(int i) {
		visit[i] = true;
		System.out.print(i + " ");
		for (int j = 1; j < v + 1; j++) {
			if (ad[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}

	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visit[i] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");

			for (int j = 1; j < v + 1; j++) {
				if (ad[temp][j] == 1 && visit[j] == false) {
					q.offer(j);
					visit[j] = true;
				}
			}
		}

	}

}
