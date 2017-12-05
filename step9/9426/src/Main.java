import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String[] sp = br.readLine().split(" ");
		int size = Integer.parseInt(sp[0]);
		int partial = Integer.parseInt(sp[1]);
		int[] arr = new int[size + 1];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int midIndex = (partial + 1) / 2;
		BigInteger big = new BigInteger("0");
		for (int i = midIndex; i <= (size - midIndex + 1); i++) {
			big = big.add(BigInteger.valueOf(arr[i]));
		}
		System.out.println(big);
	}

}
