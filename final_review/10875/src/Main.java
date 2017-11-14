import java.io.*;
import java.util.*;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class Main {
	// E N W S
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int L;

	static LinkedList<Line> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		L = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String[] sp = null;

		LinkedList<Line> list = new LinkedList<Line>();
		list.addLast(new Line(-L, L, L, L, 5));
		list.addLast(new Line(-L, L, -L, -L, 5));
		list.addLast(new Line(L, -L, -L, -L, 5));
		list.addLast(new Line(L, -L, L, L, 5));

		sp = br.readLine().split(" ");
		int len = Integer.parseInt(sp[0]);
		int dir = 0;
		int check = 0;
		long sum = 0;
		boolean flag = false;

		Line l = new Line(0, 0, dx[dir] * len, dy[dir] * len, dir);
		for (int j = 0; j < list.size() - 1; j++) {
			check = l.intersect(list.get(j));
			if (check != -1) {
				flag = true;
				break;
			}
		}
		if (flag) {
			sum += check;
		} else {
			sum += len;
			list.addLast(l);
		}
		if (sp[1].equals("L")) {
			dir = (dir + 1) % 4;
		} else {
			dir = ((dir - 1 + 4) % 4);
		}

		for (int i = 0; i < n - 1; i++) {
			sp = br.readLine().split(" ");
			len = Integer.parseInt(sp[0]);
			int ex = list.getLast().ex;
			int ey = list.getLast().ey;
			l = new Line(ex, ey, ex + (len * dx[dir]), ey + (len * dy[dir]), dir);
			//
			list.addLast(l);

			if (sp[1].equals("L")) {
				dir = (dir + 1) % 4;
			} else {
				dir = ((dir - 1 + 4) % 4);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			// System.out.print("(" + list.get(i).sx + "," + list.get(i).sy + ")");
			// System.out.print("(" + list.get(i).ex + "," + list.get(i).ey + ")/");
			// System.out.print(list.get(i).dir + "__");
			list.get(i).print();
			System.out.println(list.getLast().intersect(list.get(i)));

		}
		System.out.println();
		Line l1 = new Line(0, 0, 10, 0, 0);
		Line l2 = new Line(3, -3, 3, 3, 1);
		System.out.println(l1.intersect(l2));
		System.out.println(sum);

	}
}

class Line {
	// start, end
	int sx, sy, ex, ey;
	int dir;

	public Line(int sx, int sy, int ex, int ey, int dir) {
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
		this.dir = dir;
	}

	public int intersect(Line b) {
		switch (this.dir) {
		case 0:
			if (b.dir == 1 || b.dir == 3) {
				if ((this.sx <= b.sx && b.sx <= this.ex) && (b.minY() <= this.ey && this.ey <= b.maxY())) {
					return b.sx - this.sx;
				}
			} else {
				if ((this.sx <= b.minX() && b.minX() <= this.ex) && (this.ey == b.ey)) {
					return b.minX() - this.sx;
				}
			}
			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		}
		return -1;
	}

	public int minX() {
		return Math.min(sx, ex);
	}

	public int maxX() {
		return Math.max(sx, ex);
	}

	public int minY() {
		return Math.min(sy, ey);
	}

	public int maxY() {
		return Math.max(sy, ey);
	}

	public void print() {
		System.out.println("(" + sx + "," + sy + ")" + "(" + ex + "," + ey + ")" + dir);
	}
}
