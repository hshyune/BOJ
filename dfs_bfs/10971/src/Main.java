import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			int[][] adj = new int[n][n];
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < n; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
				}
				arr[i] = i;
			}

			Permu p = new Permu();
			p.setAdj(adj);
			p.permu(arr, 0, n, n);
			System.out.println(p.getMin());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Permu {
	private int min = 999999999;
	private int[][] adj = null;

	public void rotateRight(int[] arr, int start, int end) {
		int last = arr[end];
		for (int i = end; i > start; i--) {
			arr[i] = arr[i - 1];
		}
		arr[start] = last;
	}

	public void rotateLeft(int[] arr, int start, int end) {
		int first = arr[start];
		for (int i = start; i < end; i++) {
			arr[i] = arr[i + 1];
		}
		arr[end] = first;
	}

	public void permu(int[] arr, int depth, int n, int k) throws IOException {
		if (depth == k) {
			int dist = 0;
			if (!isZero(arr, n)) {
				dist = getDist(arr, n);
				if (min > dist) {
					min = dist;
				}
			}
			return;
		}
		for (int i = depth; i < n; i++) {
			rotateRight(arr, depth, i);
			permu(arr, depth + 1, n, k);
			rotateLeft(arr, depth, i);
		}
	}

	public void setAdj(int[][] adj) {
		this.adj = adj;
	}

	public int getDist(int[] arr, int n) {
		int dist = 0;
		for (int i = 0; i < n - 1; i++) {
			dist += adj[arr[i]][arr[i + 1]];
		}
		dist += adj[arr[n - 1]][arr[0]];
		return dist;
	}

	public int getMin() {
		return min;
	}

	public boolean isZero(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (adj[arr[i]][arr[i + 1]] == 0)
				return true;
		}
		if (adj[arr[n - 1]][arr[0]] == 0) {
			return true;
		}
		return false;
	}
}
