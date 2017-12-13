import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String[] sp = br.readLine().split(" ");
		int[] r = new int[4];
		for (int i = 0; i < 4; i++)
			r[i] = Integer.parseInt(sp[i]);

	}

}
