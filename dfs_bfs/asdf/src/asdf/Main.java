package asdf;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OutputStreamWriter out = new OutputStreamWriter(System.out);
			BufferedWriter bw = new BufferedWriter(out);
			String str = "hi";
			bw.write(str);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}