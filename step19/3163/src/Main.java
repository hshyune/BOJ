import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp = br.readLine().split(" ");
		int N = Integer.parseInt(sp[0]);
		int L = Integer.parseInt(sp[1]);
		int k = Integer.parseInt(sp[2]);
	}

}

class Ant {
	private boolean dir;
	private int id;
	private int index;

	public Ant(String str) {
		String[] sp = str.split(" ");
		this.index = Integer.parseInt(sp[0]);
		this.id = Integer.parseInt(sp[1]);
		if (id < 0) {
			this.dir = false;
		} else {
			this.dir = true;
		}
	}

	public void go(int L, Ant[] arr) {
		if (dir) {
			if (arr[index + 1] == null) {
				dir = !dir;
				
			} else {

			}
		} else {

		}
	}
}
