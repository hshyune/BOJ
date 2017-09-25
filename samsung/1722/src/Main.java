import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in, 1);
			int n = Integer.parseInt(br.readLine());

			OutputStreamWriter out = new OutputStreamWriter(System.out);
			BufferedWriter bw = new BufferedWriter(out);
			PrintWriter pw = new PrintWriter(bw);

			int[] arr = new int[n];
			String[] sp = br.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			if (Integer.parseInt(sp[0]) == 1) {
				// get permutation
				Permu p = new Permu(n, arr, Integer.parseInt(sp[1]));
				p.setPW(pw);
				p.getPermu(arr, 0, n, n);
			} else {
				// get order
				int[] cmp = new int[n];
				for (int i = 0; i < n; i++) {
					cmp[i] = Integer.parseInt(sp[i + 1]);
				}
				Permu p = new Permu(n, cmp, -1);
				p.setPW(pw);
				p.getPermu(arr, 0, n, n);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Permu {
	private int size;
	private int[] cmp = null;
	private boolean flag = false;
	private long cnt = 1;
	private long order = -1;
	private PrintWriter pw = null;

	public Permu(int size, int[] cmp, long order) {
		this.size = size;
		this.cmp = cmp;
		this.order = order;
	}

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

	public void getPermu(int[] arr, int depth, int n, int k) throws IOException {
		if (depth == k) {
			if (order == -1) {
				if (equal(arr)) {
					pw.println(cnt);
				}
			} else {
				if (cnt == order) {
					print(arr);
					pw.flush();
					System.exit(0);
				}
			}
			cnt++;
		}
		for (int i = depth; i < n; i++) {
			rotateRight(arr, depth, i);
			getPermu(arr, depth + 1, n, k);
			rotateLeft(arr, depth, i);
		}
	}

	public void print(int[] arr) throws IOException {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			pw.print(arr[i] + " ");
		}
		pw.println(arr[size - 1]);
	}

	public boolean equal(int[] arr) {
		for (int i = 0; i < this.size; i++) {
			if (cmp[i] != arr[i])
				return false;
		}
		return true;
	}

	public void setPW(PrintWriter pw) {
		this.pw = pw;
	}
}
