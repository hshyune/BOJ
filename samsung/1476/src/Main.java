import java.io.*;

public class Main {

	final static int EARTH = 15;
	final static int SUN = 28;
	final static int MOON = 19;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);

			PrintWriter pw = new PrintWriter(System.out);
			int[] esm = new int[3];

			String[] sp = br.readLine().split(" ");
			esm[0] = Integer.parseInt(sp[0]) % EARTH;
			esm[1] = Integer.parseInt(sp[1]) % SUN;
			esm[2] = Integer.parseInt(sp[2]) % MOON;

			long sun = esm[1];
			for (int i = 0;; i++) {
				sun = (SUN * i + esm[1]);

				if ((sun % EARTH == esm[0]) && (sun % MOON == esm[2])) {
					if (sun != 0) {
						pw.println(sun);
						pw.flush();
						break;
					}
				}
			}

			pw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
