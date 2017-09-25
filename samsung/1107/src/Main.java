import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in, 1);
			int channel = Integer.parseInt(br.readLine());
			int broken = Integer.parseInt(br.readLine());
			int[] btn = new int[11];
			String[] sp = br.readLine().split(" ");
			for (int i = 0; i < broken; i++) {
				btn[Integer.parseInt(sp[i])] = 1;
			}

			PrintWriter pw = new PrintWriter(System.out);
			Remote r = new Remote(100, channel, btn);
			pw.println(r.find());
			pw.flush();
			pw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Remote {
	int channel;
	int cur;
	int[] broken = null;
	int cnt = 0;

	public Remote(int cur, int channel, int[] broken) {
		this.cur = cur;
		this.channel = channel;
		this.broken = broken;
	}

	public long find() {
		long direct = Math.abs(channel - cur);
		long near = 1000000;
		long min = 1000000;
		for (long i = 0; i < 1000001; i++) {
			if (check(i)) {
				if (Math.abs(i - channel) < Math.abs(near - channel)) {
					near = i;
				}
			}
		}
		// System.out.println("near channel: " + near);
		long res = getDigit(near) + Math.abs(near - channel);
		return Math.min(res, direct);
	}

	public boolean check(long num) {
		int size = getDigit(num);
		for (int i = 0; i < size; i++) {
			if (broken[(int) (num % 10)] == 1) {
				return false;
			}
			num /= 10;
		}
		return true;
	}

	public int getDigit(long num) {
		int len = 1;
		while (num != 0) {
			num = num / 10;
			if (num == 0) {
				break;
			}
			len++;
		}
		return len;
	}
}
