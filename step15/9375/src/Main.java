import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			ArrayList<Items> list = new ArrayList<Items>();
			int items = Integer.parseInt(br.readLine());
			String[] sp = null;
			for (int j = 0; j < items; j++) {
				sp = br.readLine().split(" ");
				boolean flag = false;
				for (Items item : list) {
					if (item.getName().equals(sp[1])) {
						item.count();
						flag = true;
					}
				}
				if (!flag) {
					list.add(new Items(sp[1], 1));
				}
			}
			int res = 1;
			for (int j = 0; j < list.size(); j++) {
				res *= list.get(j).getCount()+1;
			}
			System.out.println(res - 1);
		}
	}

}

class Items {
	private String name;
	private int count;

	public Items(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return this.name;
	}

	public int getCount() {
		return this.count;
	}

	public void count() {
		this.count++;
	}
}
