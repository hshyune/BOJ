import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			int[] data = new int[n];
			for (int i = 0; i < n; i++)
				data[i] = Integer.parseInt(br.readLine());

			System.out.println(Math.round(avg(data)));
			System.out.println(mid(data));
			System.out.println(mostAppear(data));
			System.out.println(diff(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static double avg(int[] data) {
		int size = data.length;
		int sum = 0;
		for (int i = 0; i < size; i++)
			sum += data[i];
		double res = sum / (double) size;

		return res;
	}

	public static int mid(int[] data) {
		int size = data.length;
		Arrays.sort(data);
		if (size % 2 == 0) {
			return (data[size / 2 - 1] + data[size / 2]) / 2;
		} else {
			return data[size / 2];
		}
	}

	public static int mostAppear(int[] data) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < data.length; i++) {
			if (!map.containsKey(data[i])) {
				map.put(data[i], 1);
			} else {
				int val = map.get(data[i]);
				map.replace(data[i], val + 1);
			}
		}
		int max_val = 0;
		int max_key = 0;
		for (Map.Entry<Integer, Integer> tmp : map.entrySet()) {
			if (tmp.getValue() > max_val) {
				max_val = tmp.getValue();
				max_key = tmp.getKey();
			}
		}
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> tmp : map.entrySet()) {
			if (tmp.getValue() == max_val) {
				list.add(tmp.getKey());
				cnt++;
			}
		}
		if (cnt > 1) {
			Collections.sort(list);
			return list.get(1);
		}

		else
			return list.get(0);
	}

	public static int diff(int[] data) {
		int max = -4000;
		int min = 4000;
		for (int tmp : data) {
			if (tmp > max)
				max = tmp;
			if (tmp < min)
				min = tmp;
		}
		return max - min;
	}

}
