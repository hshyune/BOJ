import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		long[] a = new long[101];
		a[1] = a[2] = a[3] = 1;
		for(int i=3;i<101;i++) {
			a[i] = a[i-3]+a[i-2];
		}
		
		for(int i=0;i<tc;i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(a[n]);
		}
	}

}
