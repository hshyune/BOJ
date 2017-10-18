package line_3;

import java.util.Arrays;
import java.util.Scanner;

class Main {

	private int[][] graph;
	private int N;

	/*
	 * Description : 어떤 자리에 대해 수요가 없을때, (한 column이 모두 -1일때) 자리 배정이 불가하게 된다. 한
	 * column의 숫자를 모두 더해서 -N이 되면 자리 배정이 불가하다 Time complexity : 2중 for loop으로 O(n^2)
	 * Space complexity : 2차 Array 사용으로 O(n^2)
	 */
	private boolean solve() {
		// TODO implement your code to here.
		boolean res = true;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[j][i] == -1)
					cnt++;
			}
			System.out.println(cnt);
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		try (Scanner scan = new Scanner(System.in)) {
			int T = scan.nextInt();

			for (int t = 0; t < T; t++) {
				int N = scan.nextInt();
				main.N = N;
				main.graph = new int[N][N];
				int K = scan.nextInt();
				
				for(int i=0;i<n;i++) {
					Arrays.fill(graph, -1);
				}
				for (int i = 0; i < K; i++) {
					int P = scan.nextInt();
					int S = scan.nextInt();
					main.graph[P][S] = 1;
				}
				System.out.println(main.solve() ? 'O' : 'X');
			}
		}
	}
}
