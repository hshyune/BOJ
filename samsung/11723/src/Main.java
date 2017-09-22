import java.io.*;
import java.util.*;

public class Main {

	final static int EMPTY = 0;
	final static int EXIST = 1;
	static int[] arr = new int[20];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in, 1);
			int n = Integer.parseInt(br.readLine());

			OutputStreamWriter out = new OutputStreamWriter(System.out);
			BufferedWriter bw = new BufferedWriter(out);
			PrintWriter pw = new PrintWriter(bw);

			for (long iter = 0; iter < n; iter++) {
				String[] sp = br.readLine().split(" ");
				switch (sp[0].charAt(0)) {
				case 'a':
					if (sp.length == 2) {
						add(Integer.parseInt(sp[1]) - 1);
					} else {
						all();
					}
					break;
				case 'r':
					remove(Integer.parseInt(sp[1]) - 1);
					break;
				case 'c':
					pw.write(Integer.toString(check(sp[1]))+"\n");

					break;
				case 't':
					toggle(Integer.parseInt(sp[1]) - 1);
					break;
				case 'e':
					empty();
					break;
				}
			}
			pw.close();
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void add(int num) {
		if (arr[num] == EMPTY) {
			arr[num] = EXIST;
		}
	}

	public static void remove(int num) {
		if (arr[num] == EXIST) {
			arr[num] = EMPTY;
		}
	}

	public static int check(String str) {
		int num = Integer.parseInt(str) - 1;
		if (arr[num] == EXIST) {
			return EXIST;
		} else {
			return EMPTY;
		}
	}

	public static void toggle(int num) {
		if (arr[num] == EXIST) {
			arr[num] = EMPTY;
		} else {
			arr[num] = EXIST;
		}
	}

	public static void all() {
		for (int i = 0; i < 20; i++) {
			arr[i] = EXIST;
		}
	}

	public static void empty() {
		for (int i = 0; i < 20; i++) {
			arr[i] = EMPTY;
		}
	}

}
