import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(out);
		PrintWriter pw = new PrintWriter(bw);
		String str = null;
		StringTokenizer st = null;
		int n = -1;
		int[] arr = null;

		while (true) {
			str = br.readLine();
			if (str.charAt(0) == '0')
				break;
			st = new StringTokenizer(str, " ");
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve(arr, pw);
			pw.println();
		}
		pw.close();
	}

	public static void solve(int[] arr, PrintWriter pw) {
		int n = arr.length;
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visit = new boolean[arr.length];
		int index = 0;
		s.push(arr[index]);
		visit[index] = true;
		while (!s.isEmpty()) {
			if (s.size() == 6) {
				// print
				for (int i = 0; i < 5; i++) {
					pw.print(s.get(i) + " ");
				}
				pw.println(s.get(5));
				// pop
				s.pop();
			} else {
				if (index + 1 < n) {
					index += 1;
					if (!visit[index]) {
						s.push(arr[index]);
						visit[getIndex(arr, s.peek())] = true;
					}
				} else {
					// search all
					index = getIndex(arr, s.peek());
					init(visit, index + 1);
					s.pop();
					if (s.size() == 0) {
						int cnt = 0;
						for (int i = 0; i < n; i++) {
							if (!visit[i]) {
								cnt++;
							}
						}
						if (cnt >= 6) {
							s.push(arr[index + 1]);
							visit[index + 1] = true;
						} else {
							break;
						}
					}
				}
			}
		}
	}

	public static int getIndex(int[] arr, int val) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (val == arr[i])
				return i;
		}
		return -1;
	}

	public static boolean isEnd(boolean[] visit, int begin) {
		int n = visit.length;
		for (int i = begin; i < n; i++) {
			if (!visit[i])
				return false;
		}
		return true;
	}

	public static boolean init(boolean[] visit, int begin) {
		int n = visit.length;
		for (int i = begin; i < n; i++) {
			visit[i] = false;
		}
		return true;
	}

}
