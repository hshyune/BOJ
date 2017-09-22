import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int rad = Integer.parseInt(br.readLine());
			double uc = Math.PI * rad * rad;
			double tx = Math.sqrt(2*rad*rad);
			
			System.out.printf("%.6f\n", uc);
			System.out.printf("%.6f", tx*tx);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
