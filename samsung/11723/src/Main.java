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

			for (long iter = 0; iter < n; iter++) {
				String[] sp = br.readLine().split(" ");
				if (sp[0].equals("add")) {
					add(Integer.parseInt(sp[1]));
				}
				if (sp[0].equals("remove")) {
					remove(Integer.parseInt(sp[1]));
				}
				if (sp[0].equals("check")) {
					bw.write(sp[1]);
					bw.flush();
				}
				if (sp[0].equals("toggle")) {
					toggle(Integer.parseInt(sp[1]));
				}
				if (sp[0].equals("all")) {
					all();
				}
				if (sp[0].equals("empty")) {
					empty();
				}
			}
			bw.close();
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void add(int num) {
		num--;
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
		int num = Integer.parseInt(str);
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
