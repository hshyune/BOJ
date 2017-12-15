import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] sp = str.split("-");
		int size = sp.length;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<size;i++) {
			sb.append(sp[i].charAt(0));
		}
		System.out.println(sb.toString());

	}

}
