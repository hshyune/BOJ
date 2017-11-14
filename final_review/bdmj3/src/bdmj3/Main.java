package bdmj3;

import java.util.*;

class Main {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {

			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			int x3 = s.nextInt();
			int y3 = s.nextInt();
			int x4 = s.nextInt();
			int y4 = s.nextInt();
			int x5 = s.nextInt();
			int y5 = s.nextInt();
			int x6 = s.nextInt();
			int y6 = s.nextInt();

			Rectangle r1 = new Rectangle(x1, y1, x2, y2);
			Rectangle r2 = new Rectangle(x3, y3, x4, y4);
			Rectangle r3 = new Rectangle(x5, y5, x6, y6);
			long s1 = r1.getArea();

			Rectangle tmp = getRect(r1, r2);
			// s1, s2
			if (tmp != null) {
				s1 -= tmp.getArea();
			}
			// s1, s3
			tmp = getRect(r1, r3);
			if (tmp != null) {
				s1 -= tmp.getArea();
			}

			// s2, s3
			tmp = getRect(r2, r3);
			if (tmp != null) {
				s1 += tmp.getArea();
			}
			System.out.println(s1);
		}
	}

	public static Rectangle getRect(Rectangle r1, Rectangle r2) {
		Point p1 = new Point(Math.max(r1.p1.x, r2.p1.x), Math.min(r1.p1.y, r2.p1.y));
		Point p2 = new Point(Math.min(r1.p2.x, r2.p2.x), Math.min(r1.p2.y, r2.p2.y));
		Point p3 = new Point(Math.min(r1.p3.x, r2.p3.x), Math.max(r1.p3.y, r2.p3.y));
		Point p4 = new Point(Math.max(r1.p4.x, r2.p4.x), Math.max(r1.p4.y, r2.p4.y));
		if (p1.x <= p2.x && p2.y >= p3.y && p3.x >= p4.x && p4.y <= p1.y) {
			return new Rectangle(p1, p2, p3, p4);
		}
		return null;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Rectangle {
	Point p1, p2, p3, p4;
	int w, h;

	public Rectangle(int x1, int y1, int x2, int y2) {
		this.p1 = new Point(x1, y2);
		this.p2 = new Point(x2, y2);
		this.p3 = new Point(x2, y1);
		this.p4 = new Point(x1, y1);
		this.w = x2 - x1;
		this.h = y2 - y1;
	}

	public Rectangle(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.w = p2.x - p1.x;
		this.h = p2.y - p3.y;
	}

	public long getArea() {
		return w * h;
	}

}
