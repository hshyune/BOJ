import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			String cmd = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String data = br.readLine();
			int len = data.length();
			data = data.substring(1, len - 1);

			LinkedList<Integer> list = new LinkedList<Integer>();
			if (!data.equals("")) {
				String[] sp = data.split(",");
				for (int j = 0; j < size; j++) {
					list.addLast(Integer.parseInt(sp[j]));
				}
			}
			boolean dir = true;
			boolean flag = true;
			len = cmd.length();
			for (int j = 0; j < len; j++) {
				if (cmd.charAt(j) == 'R') {
					dir = !dir;
				}
				if (cmd.charAt(j) == 'D') {
					if (size == 0) {
						flag = false;
						break;
					} else {
						if (dir) {
							list.removeFirst();
						} else {
							list.removeLast();
						}
						size--;
					}
				}
			}
			if (flag) {
				sb.append(print(list, dir, size) + "\n");
			} else {
				sb.append("error\n");
			}

		}
		System.out.println(sb.toString());
	}

	public static String print(LinkedList<Integer> list, boolean dir, int size) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (dir) {
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				sb.append(it.next() + ",");
			}
			if (!list.isEmpty()) {
				sb.deleteCharAt(sb.length() - 1);
			}
		} else {
			Collections.reverse(list);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				sb.append(it.next() + ",");
			}
			if (!list.isEmpty()) {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		sb.append("]");

		return sb.toString();

	}

}
