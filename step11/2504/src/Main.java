import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String str = br.readLine();
		if (isPossible(str)) {
			System.out.println(solve(str));
		} else {
			System.out.println(0);
		}

	}

	public static boolean isPossible(String str) {
		int size = str.length();
		Stack<Object> s = new Stack<Object>();
		for (int i = 0; i < size; i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				s.push(ch);
				continue;
			}
			if (ch == ')') {
				if ((char) s.peek() == '(') {
					s.pop();
					continue;
				} else {
					break;
				}
			}

			if (ch == '[') {
				s.push(ch);
				continue;
			}
			if (ch == ']') {
				if ((char) s.peek() == '[') {
					s.pop();
					continue;
				} else {
					break;
				}
			}
		}
		if (s.size() != 0) {
			return false;
		}
		return true;
	}

	public static Object solve(String str) {
		Stack<Object> s = new Stack<Object>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				s.push(String.valueOf('('));
				continue;
			}
			if (ch == ')') {
				if (s.peek().equals("(")) {
					s.pop();
					if (!s.isEmpty() && s.peek() instanceof Integer) {
						int tmp = (int) s.pop();
						s.push(tmp + 2);
						continue;
					}
					s.push(2);

				} else {
					// s.push(ch);
					if (s.peek() instanceof Integer) {
						int tmp = (int) s.pop();
						s.pop();
						tmp *= 2;
						if (!s.isEmpty() && s.peek() instanceof Integer) {
							int tmp1 = (int) s.pop();
							s.push(tmp + tmp1);
							continue;
						}
						s.push(tmp);
						continue;
					}
				}
			}

			if (ch == '[') {
				s.push(String.valueOf('['));
				continue;
			}
			if (ch == ']') {
				if (s.peek().equals("[")) {
					s.pop();
					if (!s.isEmpty() && s.peek() instanceof Integer) {
						int tmp = (int) s.pop();
						s.push(tmp + 3);
						continue;
					}
					s.push(3);

				} else {
					// s.push(ch);
					if (s.peek() instanceof Integer) {
						int tmp = (int) s.pop();
						s.pop();
						tmp *= 3;
						if (!s.isEmpty() && s.peek() instanceof Integer) {
							int tmp1 = (int) s.pop();
							s.push(tmp + tmp1);
							continue;
						}
						s.push(tmp);
						continue;
					}
				}
			}

		}
		System.out.println(s);
		return s.get(0);
	}
}
