import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				char[] stack = new char[50];
				int top = -1;
				String buf = br.readLine();
				boolean flag = true;
				for (int j = 0; j < buf.length(); j++) {
					if (buf.charAt(j) == '(') {
						if (top != 50)
							stack[++top] = '(';
					} else if (buf.charAt(j) == ')') {
						if (top != -1) {
							if (stack[top] == '(') {
								top--;
							} else {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
				if (top != -1)
					flag = false;
				if (flag)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
