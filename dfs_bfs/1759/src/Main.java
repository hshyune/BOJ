import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		PrintWriter pw = new PrintWriter(System.out);
		String[] sp = br.readLine().split(" ");
		int l = Integer.parseInt(sp[0]);
		int c = Integer.parseInt(sp[1]);

		sp = br.readLine().split(" ");
		char[] arr = new char[c];
		for (int i = 0; i < c; i++) {
			arr[i] = sp[i].charAt(0);
		}
		Permu p = new Permu();
		p.pw = pw;
		p.permu(arr, 0, c, l);
		Iterator<String> it = p.set.iterator();
		while(it.hasNext()) {
			pw.println(it.next());
		}

		pw.flush();
		pw.close();
		br.close();
	}

}

class Permu {
	PrintWriter pw = null;
	SortedSet<String> set = new TreeSet<String>();
	ArrayList<String> list = new ArrayList<String>();

	public void rotateRight(char[] arr, int start, int end) {
		char last = arr[end];
		for (int i = end; i > start; i--) {
			arr[i] = arr[i - 1];
		}
		arr[start] = last;
	}

	public void rotateLeft(char[] arr, int start, int end) {
		char first = arr[start];
		for (int i = start; i < end; i++) {
			arr[i] = arr[i + 1];
		}
		arr[end] = first;
	}

	public void permu(char[] arr, int depth, int n, int k) throws IOException {
		if (depth == k) {
			char[] tmp = new char[k];
			for (int i = 0; i < k; i++) {
				tmp[i] = arr[i];
			}
			if (isAscend(tmp)) {
				if (is1Vowel(tmp) && is2Consonant(tmp)) {
					String str = "";
					for (int i = 0; i < k; i++) {
						str += tmp[i];
					}
					set.add(str);
				}
			}
			return;
		}
		for (int i = depth; i < n; i++) {
			rotateRight(arr, depth, i);
			permu(arr, depth + 1, n, k);
			rotateLeft(arr, depth, i);
		}
	}

	public boolean isAscend(char[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}

	public boolean is1Vowel(char[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
				res++;
		}
		if (res >= 1)
			return true;
		return false;
	}

	public boolean is2Consonant(char[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!(arr[i] == 'a' && arr[i] == 'e' && arr[i] == 'i' && arr[i] == 'o' && arr[i] == 'u'))
				res++;
		}
		if (res >= 2)
			return true;
		return false;
	}

}