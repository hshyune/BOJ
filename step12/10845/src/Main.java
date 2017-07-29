import java.io.*;
import java.util.ArrayList;

class Queue {
	ArrayList<Integer> data;
	int max;

	public Queue() {
		data = new ArrayList<Integer>();
		max = 10000;
	}

	public void push(int num) {
		if (data.size() == max)
			return;
		data.add(num);
	}

	public int pop() {
		if (data.size() == 0)
			return -1;
		return data.remove(0);
	}

	public int size() {
		return data.size();
	}

	public int empty() {
		if (data.isEmpty())
			return 1;
		return 0;
	}

	public int front() {
		if (data.isEmpty())
			return -1;
		return data.get(0);
	}

	public int back() {
		if (data.isEmpty())
			return -1;
		return data.get(data.size() - 1);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int cmd = Integer.parseInt(br.readLine());

			Queue q = new Queue();
			for (int i = 0; i < cmd; i++) {
				String str = br.readLine();
				String[] s = str.split(" ");
				if (s.length == 1) {
					if (s[0].equals("pop")) {
						System.out.println(q.pop());
					}
					if (s[0].equals("size")) {
						System.out.println(q.size());
					}
					if (s[0].equals("empty")) {
						System.out.println(q.empty());
					}
					if (s[0].equals("front")) {
						System.out.println(q.front());
					}
					if (s[0].equals("back")) {
						System.out.println(q.back());
					}
				}
				if (s.length == 2) {
					if (s[0].equals("push")) {
						int para = Integer.parseInt(s[1]);
						q.push(para);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
