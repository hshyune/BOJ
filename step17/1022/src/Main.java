import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String[] sp = br.readLine().split(" ");
			int[] r = new int[4];
			for (int i = 0; i < 4; i++)
				r[i] = Integer.parseInt(sp[i]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
