import java.io.*;
import java.util.*;

class Dequeue {
	LinkedList<Integer> data;

	public Dequeue() {
		data = new LinkedList<Integer>();
	}

	public void command(String str) {
		String[] sp = str.split(" ");
		if (sp.length == 1) {
			if (str.equals("size")) {
				System.out.println(this.size());
			}
			if (str.equals("empty")) {
				System.out.println(this.empty());
			}
			if (str.equals("front")) {
				System.out.println(this.front());
			}
			if (str.equals("back")) {
				System.out.println(this.back());
			}
			if (str.equals("pop_front")) {
				System.out.println(this.pop_front());
			}
			if (str.equals("pop_back")) {
				System.out.println(this.pop_back());
			}
			return;
		} else {
			if (sp[0].equals("push_front")) {
				int para = Integer.parseInt(sp[1]);
				data.addFirst(para);
			}
			if (sp[0].equals("push_back")) {
				int para = Integer.parseInt(sp[1]);
				data.addLast(para);
			}
			return;
		}
	}

	private void push_front(int x) {
		data.addFirst(x);
	}

	private void push_back(int x) {
		data.addLast(x);
	}

	private int pop_front() {
		if (data.isEmpty()) {
			return -1;
		} else {
			return data.removeFirst();
		}
	}

	private int pop_back() {
		if (data.isEmpty()) {
			return -1;
		} else {
			return data.removeLast();
		}
	}

	private int size() {
		return data.size();
	}

	private int empty() {
		if (data.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int front() {
		if (data.isEmpty())
			return -1;
		return data.getFirst();
	}

	private int back() {
		if (data.isEmpty())
			return -1;
		return data.getLast();
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			Dequeue d = new Dequeue();
			for (int i = 0; i < n; i++) {
				d.command(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
