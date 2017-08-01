import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			String[] sp = br.readLine().split(" ");
			int n = Integer.parseInt(sp[0]);
			int kim = Integer.parseInt(sp[1]);
			int lim = Integer.parseInt(sp[2]);

			int diff = lim - kim;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
