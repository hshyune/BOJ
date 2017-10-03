import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(out);
		PrintWriter pw = new PrintWriter(bw);
		int n = Integer.parseInt(br.readLine());
		short[] arr = new short[10001];
		for (int i = 0; i < n; i++) {
			short num = Short.parseShort(br.readLine());
			arr[num]++;
		}

		StringBuffer buffer = new StringBuffer();
		for (int i = 1; i <= n;) {
			if (arr[i] == 0)
				i++;
			else {
				arr[i]--;
				buffer.append(i + "\n");
			}
		}
		pw.println(buffer);
		pw.close();
		br.close();
	}

}
