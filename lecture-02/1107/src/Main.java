import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PrintWriter pw = new PrintWriter(bw);

		Scanner sc = new Scanner(System.in);
		int channel = sc.nextInt();
		int broken = sc.nextInt();
		BitSet bit = new BitSet(10);
		for (int i = 0; i < broken; i++) {
			bit.set(sc.nextInt());
		}

		int now = 100;
		int near = 1000000;
		int direct = Math.abs(channel - now);
		// why 1000000
		// 155555 - 500000 - 511111
		for (int i = 0; i < 1000001; i++) {
			// check btn
			if (check(i, bit)) {
				if (Math.abs(i - channel) < Math.abs(near - channel)) {
					near = i;
				}
			}
		}
		long res = getDigit(near) + Math.abs(near - channel);
		pw.println(Math.min(res, direct));
		pw.close();
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

	public static boolean check(int num, BitSet bit) {
		int size = getDigit(num);

		int tmp = num;
		for (int i = 0; i < size; i++) {
			if (bit.get(tmp % 10)) {
				return false;
			}
			tmp = tmp / 10;
		}
		return true;
	}

}
