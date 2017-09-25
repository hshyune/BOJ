import java.util.*;

public class Main {

	static int[] btn = null;
	static int channel = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		channel = sc.nextInt();
		int broken = sc.nextInt();

		btn = new int[11];
		for (int i = 0; i < broken; i++) {
			btn[sc.nextInt()] = 1;
		}
		System.out.println(find());
	}

	public static boolean check(int num) {
		int size = getDigit(num);
		for (int i = 0; i < size; i++) {
			if (btn[(num % 10)] == 1) {
				return false;
			}
			num /= 10;
		}
		return true;
	}

	public static int getDigit(int num) {
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

	public static long find() {
		int direct = Math.abs(channel - 100);
		int near = 1000000;
		for (int i = 0; i < 1000001; i++) {
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

}