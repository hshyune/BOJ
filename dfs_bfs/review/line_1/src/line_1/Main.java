import java.util.Scanner;

public class Main {

	// Description :
	// Time complexity :
	// Space complexity :
	public int calc(int[] tokens) {
		// TODO : implement your codes to here.
		double pivot = 9.5;
		double now = 0;
		double size = tokens.length;
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			now += tokens[i];
		}

		while (true) {
			if (now / size < pivot) {
				now += 10;
				cnt++;
				size++;
			} else {
				break;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] tokens = new int[n];
		for (int i = 0; i < n; i++)
			tokens[i] = scanner.nextInt();

		System.out.println(main.calc(tokens));

		scanner.close();
	}
}