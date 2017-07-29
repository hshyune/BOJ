import java.io.*;
import java.util.*;

class Head {
	private int len;
	private ArrayList<String> list;

	public Head(String str) {
		this.len = str.length();
		this.list = new ArrayList<String>();
		this.list.add(str);
	}

	public ArrayList<String> getList() {
		return this.list;
	}

	public int getLen() {
		return len;
	}
}

class Desc implements Comparator<Head> {
	public int compare(Head h1, Head h2) {
		return h1.getLen() - h2.getLen();
	}
}

class Data {
	ArrayList<Head> bucket;

	public Data() {
		this.bucket = new ArrayList<Head>();
	}

	public void put(String str) {
		int len = str.length();
		for (Head tmp : bucket) {
			if (tmp.getLen() == len) {
				if (tmp.getList().contains(str)) {
					return;
				} else {
					tmp.getList().add(str);
					return;
				}
			}
		}
		Head h = new Head(str);
		bucket.add(h);
	}

	private void sort() {
		Collections.sort(bucket, new Desc());
		for (Head tmp : bucket) {
			Collections.sort(tmp.getList());
		}
	}

	public void printAll() {
		sort();
		for (Head head : bucket) {
			for (String str : head.getList()) {
				System.out.println(str);
			}
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			Data data = new Data();
			for (int i = 0; i < n; i++) {
				data.put(br.readLine());
			}
			data.printAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
