import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		int n = Integer.parseInt(br.readLine());
		int[][] adj = new int[n + 1][n + 1];
		StringTokenizer st = null;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] city = new int[n];
		for (int i = 0; i < n; i++) {
			city[i] = i + 1;
		}

		int min = Integer.MAX_VALUE;
		min = getCost(city, adj);
		while (permutation(city)) {
			int cost = getCost(city, adj);
			if (cost != -1) {
				min = Math.min(min, cost);
			}
		}
		System.out.println(min);

	}

	public static boolean permutation(int[] arr) {
		int i = -1;
		for (int k = 1; k < arr.length; k++) {
			if (arr[k - 1] < arr[k]) {
				i = k;
			}
		}
		if (i == -1) {
			return false;
		}
		int j = -1;
		for (int k = i; k < arr.length; k++) {
			if (arr[i - 1] < arr[k]) {
				j = k;
			}
		}

		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;

		Arrays.sort(arr, i, arr.length);
		return true;
	}

	public static int getCost(int[] city, int[][] adj) {
		int res = 0;
		for (int i = 1; i < city.length; i++) {
			if (adj[city[i - 1]][city[i]] == 0) {
				return -1;
			}
			res += adj[city[i - 1]][city[i]];
		}
		if (adj[city[city.length - 1]][city[0]] == 0) {
			return -1;
		}
		res += adj[city[city.length - 1]][city[0]];
		return res;
	}

}
