import java.io.*;
import java.util.*;

class RotateQ {
	LinkedList<Integer> q;
	int[] arr;
	int cnt;

	public RotateQ(String[] sp) {
		q = new LinkedList<Integer>();
		arr = new int[sp.length];
		for (int i = 0; i < sp.length; i++) {
			q.add(Integer.parseInt(sp[i]));
			arr[i] = Integer.parseInt(sp[i]);
		}
		cnt = 0;
	}

	public int pick() {
		if (q.size() == 0) {
			return -1;
		}
		return q.removeFirst();
	}

	public void rotateL() {
		if (q.size() != 0) {
			q.addLast(q.removeFirst());
		}
	}

	public void rotateR() {
		if (q.size() != 0) {
			q.addFirst(q.removeLast());
		}
	}

	private void op(int num) {
		while (true) {
			int left = q.indexOf(num);
			int size = q.size();
			int right = size - left - 1;

			if (left == 0) {
				q.removeFirst();
				break;
			}
			if (left <= right) {
				this.rotateL();
				cnt++;
			}
			if (left > right) {
				this.rotateR();
				cnt++;
			}

		}
		System.out.println(q);
	}

	public void start() {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			op(arr[i]);
		}
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String[] sp = br.readLine().split(" ");
			int n = Integer.parseInt(sp[0]);
			int m = Integer.parseInt(sp[1]);

			RotateQ q = new RotateQ(br.readLine().split(" "));
			q.start();
			System.out.println(q.cnt);
		} catch (IOException e) {

		}
	}

}
