import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int max = 0;
			for (int i = 0; i < 4; i++) {
				String[] sp = br.readLine().split(" ");
				int out = Integer.parseInt(sp[0]);
				int in = Integer.parseInt(sp[1]);
				int tmp = max + in - out;
				if(max < tmp)
					max = tmp;
			}
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
