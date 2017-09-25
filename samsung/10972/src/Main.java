import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in, 1);
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			int[] cmp = new int[n];
			String[] sp = br.readLine().split(" ");

			int flag = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
				cmp[i] = Integer.parseInt(sp[i]);
				if (cmp[i] == n - i)
					flag++;
			}
			if (flag == n) {
				System.out.println(-1);
				System.exit(0);
			}

			Permu p = new Permu(n, cmp);
			p.permu(arr, 0, n, n);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Permu {
	private int size;
	private int[] cmp = null;
	private boolean flag = false;

	public Permu(int size, int[] cmp) {
		this.size = size;
		this.cmp = cmp;
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

	public void permu(int[] arr, int depth, int n, int k) throws IOException {
		if (depth == k) {
			if (flag) {
				print(arr);
				System.exit(0);
			}
			if (equal(arr)) {
				flag = true;
				// print(arr);
			}
			// print(arr);
			return;
		}
		for (int i = depth; i < n; i++) {
			rotateRight(arr, depth, i);
			permu(arr, depth + 1, n, k);
			rotateLeft(arr, depth, i);
		}
	}

	public void print(int[] arr) throws IOException {
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(out);
		PrintWriter pw = new PrintWriter(bw);
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			pw.print(arr[i] + " ");
		}
		pw.println(arr[size - 1]);
		pw.close();
	}

	public boolean equal(int[] arr) {
		for (int i = 0; i < this.size; i++) {
			if (cmp[i] != arr[i])
				return false;
		}
		return true;
	}
}
