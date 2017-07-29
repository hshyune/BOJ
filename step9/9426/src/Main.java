import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken(" "));
			int k = Integer.parseInt(st.nextToken(" "));
			int[] data = new int[n];
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(br.readLine());
			}
			int sep = n - k + 1;
			long sum = 0;
			
			for (int i = 0; i < sep; i++) {
				sum += getMedian(data, i, k);
			}
			System.out.println(sum);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getMedian(int[] data, int start, int k) {
		int index = ((k + 1) / 2) - 1;
		int[] tmp = new int[k];
		for (int i = 0; i < k; i++) {
			tmp[i] = data[start + i];
		}
		Arrays.sort(tmp);
		return tmp[index];
	}

}
