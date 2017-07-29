import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int cmd = Integer.parseInt(br.readLine());

			int[] stack = new int[10000];
			int top = -1;

			for (int i = 0; i < cmd; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				if (st.countTokens() == 1) {
					switch (str) {
					case "pop":
						if (top == -1){
							System.out.println("-1");
							break;
						}
						System.out.println(stack[top--]);
						break;
					case "size":
						System.out.println(top+1);
						break;
					case "empty":
						if (top == -1)
							System.out.println("1");
						else
							System.out.println("0");
						break;
					case "top":
						if (top == -1)
							System.out.println("-1");
						else {
							System.out.println(stack[top]);
						}
						break;
					}
				} else {
					String s1 = st.nextToken();
					String s2 = st.nextToken();
					if (s1.equals("push")) {
						if (top + 1 != 10000) {
							stack[++top] = Integer.parseInt(s2);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
