import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		// while (sp.length != 1) {
		//
		// }
		int n = Integer.parseInt(sp[0]);
		int[] arr = new int[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = Integer.parseInt(sp[i]);
		}
		dfs(arr);
	}

	public static void solve(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visit = new boolean[arr.length];

		int index = 0;
		visit[arr[index]] = true;
		s.push(arr[index]);
		while (!s.isEmpty()) {
			if (s.size() == 6) {
				// print
				for (int i = 0; i < 6; i++) {
					System.out.print(s.get(i) + " ");
				}
				System.out.println();
				break;
			} else {
			}
		}
	}

	public static int getIndex(int[] arr, int val) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val) {
				return i;
			}
		}
		return -1;
	}

	public static int getNext(Stack<Integer> s, int[] arr, boolean[] visit) {
		if (s.isEmpty()) {
			for (int i = 0; i < arr.length; i++) {
				if (!visit[i])
					return arr[i];
			}
		}
		int top = s.peek();
		int index = getIndex(arr, top);
		for (int i = index + 1; i < arr.length; i++) {
			if (!visit[i])
				return arr[i];
		}
		return -1;
	}
}
