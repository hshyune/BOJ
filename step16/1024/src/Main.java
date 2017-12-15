import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp = br.readLine().split(" ");
		int N = Integer.parseInt(sp[0]);
		int L = Integer.parseInt(sp[1]);
		
		int mid = N / L;
		if (mid % 2 == 1) {
			
		} else {
			int[] arr = new int[L];
			for(int i=0;i<L;i++) {
				arr[i] = mid;
			}
			System.out.println(mid);
		}

	}

}
