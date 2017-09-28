import java.io.*;
import java.util.*;

public class Main {

	static String str = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			PrintWriter pw = new PrintWriter(System.out);

			String[] sp = null;
			while (true) {
				sp = br.readLine().split(" ");
				if (sp.length == 1)
					break;

				int n = sp.length - 1;
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(sp[i + 1]);
				}
				Combination c = new Combination(arr, pw);
				c.comb(n, 6, 0);
				pw.print("\n");
			}
			pw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Combination {
	private int[] arr;
	private Stack<Integer> s;
	PrintWriter pw = null;

	public Combination(int[] arr, PrintWriter pw) {
		this.arr = arr;
		s = new Stack<Integer>();
		this.pw = pw;
	}

	public void comb(int n, int r, int index) {
		// nCr, index= location current array
		if (r == 0) {
			// no more element to pick
			// System.out.println(s);
			print();
			return;
		} else if (n == r) {
			for (int i = 0; i < n; i++) {
				s.push(arr[index + i]);
			}
			print();
			// System.out.println(s);
			for (int i = 0; i < n; i++) {
				s.pop();
			}
		} else {
			// 점화식대로 분기
			// index를 포함하는 경우
			s.push(arr[index]);
			comb(n - 1, r - 1, index + 1);

			// index를 포함하지 않는 경우
			s.pop();
			comb(n - 1, r, index + 1);
		}
	}
	// http://bumbums.tistory.com/2

	public void print() {
		String str = "";
		int size = s.size();
		for (int i = 0; i < size - 1; i++) {
			str += s.get(i) + " ";
		}
		str += s.get(size - 1);
		pw.println(str);
	}
}
