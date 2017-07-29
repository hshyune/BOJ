import java.io.*;
import java.util.*;

class Task {
	private int priority;
	private boolean select;

	public Task(int p, boolean s) {
		this.priority = p;
		this.select = s;
	}

	public void setSelect() {
		this.select = true;
	}

	public int getInt() {
		return this.priority;
	}

	public boolean getSelect() {
		return this.select;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int testcase = Integer.parseInt(br.readLine());
			for (int i = 0; i < testcase; i++) {
				String buf = br.readLine();
				String[] sp = buf.split(" ");
				int size = Integer.parseInt(sp[0]);
				int want = Integer.parseInt(sp[1]);
				if (want == 0) {

				}

				buf = br.readLine();
				sp = buf.split(" ");
				ArrayList<Task> q = new ArrayList<Task>();
				for (int j = 0; j < size; j++) {
					q.add(new Task(Integer.parseInt(sp[j]), false));
				}
				q.get(want).setSelect();

				int out = 0;

				while (!q.isEmpty()) {
					Task t = q.get(0);
					boolean pass = false;
					if (q.size() > 1) {
						for (int k = 1; k < q.size(); k++) {
							if (t.getInt() < q.get(k).getInt()) {
								q.remove(0);
								q.add(t);
								pass = true;
								break;
							}
						}
					}

					if (pass) {
						continue;
					} else {
						out++;
						if (q.remove(0).getSelect())
							break;
					}
				}

				System.out.println(out);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
