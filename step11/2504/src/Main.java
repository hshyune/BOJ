import java.io.*;

class Stack {
	private long[] stack;
	private int top;
	private int max;

	public Stack() {
		max = 30;
		stack = new long[max];
		top = -1;
	}

	public void push(long ch) {
		if (top == max - 1) {
			return;
		} else {
			stack[++top] = ch;
		}
	}

	public long pop() {
		if (top == -1)
			return '0';
		else {
			return stack[top--];
		}
	}

	public long top() {
		if (top == -1)
			return '0';
		else {
			return stack[top];
		}
	}

	public int size() {
		return top + 1;
	}

	public long[] getArr() {
		return stack;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String str = br.readLine();
			Stack s = new Stack();

			for (int i = 0; i < str.length(); i++) {
				int ch = str.charAt(i);
				if (ch == ')') {
					if (s.size() > 0 && s.top() == '(') {
						s.pop();
						if (!isParen(s.top()) && s.size() != 0) {
							s.push(s.pop() + 2);
						} else
							s.push(2);
						continue;
					}
					if (s.size() > 1) {
						if (!isParen(s.top())) {
							long num = s.pop();
							if (s.top() == '(') {
								s.pop();
								if (!isParen(s.top()) && s.size() != 0) {
									long n = s.pop();
									n = num * 2 + n;
									s.push(n);
								} else {
									s.push(num * 2);
								}
								continue;
							}
						}
					}
				}
				if (ch == ']') {
					if (s.size() > 0 && s.top() == '[') {
						s.pop();
						if (!isParen(s.top()) && s.size() != 0) {
							s.push(s.pop() + 3);
						} else
							s.push(3);
						continue;
					}
					if (s.size() > 1) {
						if (!isParen(s.top())) {
							long num = s.pop();
							if (s.top() == '[') {
								s.pop();
								if (!isParen(s.top()) && s.size() != 0) {
									long n = s.pop();
									n = num * 3 + n;
									s.push(n);
								} else {
									s.push(num * 3);
								}
								continue;
							}
						}
					}
				}
				s.push(ch);
			}
			if (s.size() > 1 || isParen(s.top())){
				System.out.println("0");
				System.exit(0);
			}
				System.out.println(s.top());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isParen(long ch) {
		if (ch == '(')
			return true;
		if (ch == ')')
			return true;
		if (ch == '[')
			return true;
		if (ch == ']')
			return true;
		return false;
	}

}
