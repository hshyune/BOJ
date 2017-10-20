import java.io.*;
import java.util.*;

public class Main {
	// E N W S
	static int[] drow = { 0, 1, 0, -1 };
	static int[] dcol = { 1, 0, -1, 0 };
	static int L;

	static LinkedList<Point> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		L = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		LinkedList<Point> cmd = new LinkedList<Point>();
		String[] sp = null;
		int dir = 0;
		for (int i = 0; i < n; i++) {
			sp = br.readLine().split(" ");
			Point p = new Point(Integer.parseInt(sp[0]), 0, sp[1]);
			cmd.add(p);
		}

		System.out.println(snake(cmd));
	}

	public static int snake(LinkedList<Point> cmd) {
		int sec = 0;
		int dir = 0;

		LinkedList<Point> list = new LinkedList<Point>();
		list.add(new Point(0, 0, "E"));
		while (true) {
			Point p = cmd.getFirst();
			for (int i = 0; i < p.row; i++) {
				Point head = new Point(list.getFirst().row + drow[dir], list.getFirst().col + dcol[dir], " ");
				list.addFirst(head);

				int size = list.size();

				sec++;

				for (int j = 1; j < size; j++) {
					if (head.row == list.get(j).row && head.col == list.get(j).col) {
						return sec;
					}
				}
				if (head.row < -L || head.row > L || head.col < -L || head.col > L) {
					return sec;
				}

				// for (Point t : list) {
				// System.out.print("(" + t.row + " " + t.col + ") - ");
				// }
				// System.out.println();
			}
			if (p.dir.equals("L")) {
				dir = (dir + 1) % 4;
			} else {
				dir = Math.abs((dir - 1) % 4);
			}
			cmd.removeFirst();

			if (cmd.size() == 0)
				break;
		}
		return sec;
	}

}

class Point {
	int row;
	int col;
	String dir;

	public Point(int row, int col, String dir) {
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
}
