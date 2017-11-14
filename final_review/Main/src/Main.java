import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	static Stack<Integer> s;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] sp = br.readLine().split(" ");
			if (sp.length == 1) {
				break;
			}
			int n = Integer.parseInt(sp[0]);
			s = new Stack<Integer>();
			visit = new boolean[n];
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(sp[i + 1]);
			}
			System.out.println(Arrays.toString(arr));
		}

	}

	public static void dfs(int[] arr, int depth) {
		if (s.size() == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(s.get(i) + " ");
			}
			System.out.println();
			s.pop();
		}

		else {

		}
	}

}
