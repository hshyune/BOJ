import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int n;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			n = Integer.parseInt(br.readLine());

			int[] data = new int[n];
			for (int i = 0; i < n; i++)
				data[i] = Integer.parseInt(br.readLine());

			data = radixSort(data);
			for (int tmp : data) {
				System.out.println(tmp);
			}
		} catch (IOException e) {

		}
	}

	public static int[] radixSort(int[] array) {
		for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
			int[] tmp = new int[array.length];
			int j = 0;
			for (int i = 0; i < array.length; i++) {
				boolean move = array[i] << shift >= 0;
				if (shift == 0 ? !move : move) {
					tmp[j] = array[i];
					j++;
				} else {
					array[i - j] = array[i];
				}
			}
			for (int i = j; i < tmp.length; i++) {
				tmp[i] = array[i - j];
			}
			array = tmp;
		}

		return array;

	}

}