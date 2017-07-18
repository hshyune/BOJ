import java.io.*;
import java.util.*;

class Element implements Comparable<Element> {
	String data;
	int len;

	public Element(String str) {
		setData(str);
	}

	public void setData(String str) {
		this.data = str;
		this.len = data.length();
	}

	public int getLen() {
		return this.len;
	}

	public String getData() {
		return this.data;
	}

	public int compareTo(Element o) {
		if (Comparators.LEN.compare(this, o) == 0) {
			if (Comparators.DATA.compare(this, o) < 0)
				return -1;
			else if (Comparators.DATA.compare(this, o) < 0)
				return 0;
			else
				return 1;
		} else
			return Comparators.LEN.compare(this, o);
	}

	public static class Comparators {
		public static Comparator<Element> LEN = new Comparator<Element>() {
			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				return o1.getLen() - o2.getLen();
			}
		};

		public static Comparator<Element> DATA = new Comparator<Element>() {
			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				if (o1.getLen() == o2.getLen())
					return o1.getData().compareTo(o2.getData());
				else
					return 0;
			}
		};
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());

			ArrayList<Element> data = new ArrayList<Element>();
			for (int i = 0; i < n; i++)
				data.add(new Element(br.readLine()));

			Collections.sort(data, Element.Comparators.LEN);
			for (int i = 0; i < n - 1; i++) {
				if (data.get(i).getData().equals(data.get(i + 1).getData())) {
					data.remove(i);
					n--;
				}
			}
			Collections.sort(data, Element.Comparators.DATA);
			for (Element tmp : data) {
				System.out.println(tmp.getData());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}