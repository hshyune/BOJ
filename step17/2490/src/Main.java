import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			for (int j = 0; j < 3; j++) {
				String[] sp = br.readLine().split(" ");
				int sum = 0;
				for (int i = 0; i < 4; i++) {
					sum += Integer.parseInt(sp[i]);
				}
				switch (sum) {
				case 0:
					System.out.println("D");
					break;
				case 1:
					System.out.println("C");
					break;
				case 2:
					System.out.println("B");
					break;
				case 3:
					System.out.println("A");
					break;
				case 4:
					System.out.println("E");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
