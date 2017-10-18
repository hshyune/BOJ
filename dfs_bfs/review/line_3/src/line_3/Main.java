package line_3;

import java.util.Arrays;
import java.util.Scanner;

class Main {

	private int[][] graph;
	private int N;

	/*
	 * Description : � �ڸ��� ���� ���䰡 ������, (�� column�� ��� -1�϶�) �ڸ� ������ �Ұ��ϰ� �ȴ�. ��
	 * column�� ���ڸ� ��� ���ؼ� -N�� �Ǹ� �ڸ� ������ �Ұ��ϴ� Time complexity : 2�� for loop���� O(n^2)
	 * Space complexity : 2�� Array ������� O(n^2)
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
