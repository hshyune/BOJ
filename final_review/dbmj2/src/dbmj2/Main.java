package dbmj2;

import java.util.*;

class Main {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			LinkedList<Node> list = new LinkedList<Node>();
			Node head = new Node(-1, 0);
			Node tail = new Node(Integer.MAX_VALUE, 0);
			list.addLast(head);
			list.addLast(tail);

			for (int i = 0; i < n; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				int begin = 0;
				int end = 0;
				for (int j = 1; j < list.size(); j++) {
					if (list.get(j).num >= a) {
						list.add(j, new Node(a));
						if (list.get(j - 1) != head && list.get(j + 1) != tail) {
							list.get(j).cnt = list.get(j - 1).cnt + 1;
						}
						begin = j;
						break;
					}
				}

				for (int j = 1; j < list.size(); j++) {
					if (list.get(j).num > b) {
						list.add(j, new Node(b, 0));
						if (list.get(j - 1) != head && list.get(j + 1) != tail) {
							list.get(j - 1).cnt += 1;
						}
						end = j;
						break;
					}
				}

			}
			for (Node tmp : list) {
				System.out.println(tmp.num + " " + tmp.cnt);
			}
			int prev = 0;
			list.removeFirst();
			System.out.println("(-," + list.getFirst().num + ")");
			list.removeFirst();

			StringBuilder sb = new StringBuilder();
			int i = 0;
			while (!list.isEmpty()) {
				if (list.get(i).cnt % 2 != 0) {
					prev = list.remove(i).cnt;
				} else {
					if (Math.abs(list.get(i).cnt - prev) == 1) {
						sb.append("[" + list.get(i).num + ",");
						prev = list.get(i).cnt;
					} else {
						sb.append("(" + list.get(i).num + ",");
						prev = list.get(i).cnt;
					}
					i++;
				}
			}
			list.removeLast();
			System.out.println("(" + list.getLast().num + ",+)");
			for (Node tmp : list) {
				System.out.println(tmp.num + " " + tmp.cnt);
			}
		}
	}
}

class Node {
	int num;
	int cnt;

	public Node(int num) {
		this.num = num;
		this.cnt = 1;
	}

	public Node(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}
