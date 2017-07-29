package lotto;

import java.util.*;

public class Number {
	int[] num;

	public Number() {
		this.num = new int[6];
	}

	private void getNum() {
		Random r = new Random();
		for (int i = 0; i < 6; i++) {
			num[i] = r.nextInt(45) + 1;
		}
		Arrays.sort(num);
	}

	public void print() {
		while (true) {
			getNum();
			if (isSeq())
				continue;
			if (isSameMod10())
				continue;
			if (!isInBound())
				continue;
			if (isAllOddEven())
				continue;
			if (isOverlap())
				continue;
			if(!isSumInBound())
				continue;
			break;
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	private boolean isSeq() {
		int tmp = num[1] - num[0];
		boolean flag = true;
		for (int i = 0; i < 5; i++) {
			if (num[i + 1] - num[i] != tmp)
				flag = false;
		}
		return flag;
	}

	private boolean isSameMod10() {
		int[] tmp = new int[6];
		for (int i = 0; i < 6; i++) {
			tmp[i] = num[i] / 10;
		}
		boolean flag = true;
		for (int i = 0; i < 5; i++) {
			if (tmp[i] != tmp[i + 1]) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private boolean isInBound() {
		if (num[0] >= 30)
			return false;
		if (num[5] <= 15)
			return false;
		return true;
	}

	private boolean isAllOddEven() {
		int tmp = num[0] % 2;
		boolean flag = true;
		;
		for (int i = 1; i < 6; i++) {
			if (num[i] % 2 != tmp)
				flag = false;
		}
		return flag;
	}

	private boolean isOverlap() {
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			if (num[i + 1] == num[i])
				flag = true;
		}
		return flag;
	}

	private boolean isSumInBound() {
		int max = 180;
		int min = 96;
		int sum = 0;
		for (int i : num)
			sum += i;
		if (min <= sum && sum <= max) {
			return true;
		}
		return false;
	}
}
