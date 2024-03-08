package Chapter01;

import java.util.Scanner;

public class T1209 {
	public static final int N = 10;
	static int n;
	static int ans;
	static boolean[] stat = new boolean[N];
	static boolean[] copy = new boolean[N];

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs_a(0, 0);
		System.out.println(ans);
	}

	/**
	 * @param u 已经枚举了u个数字
	 * @param a
	 */
	private static void dfs_a (int u, int a) {
		if (a >= n) return;
		if (a > 0) dfs_c(u, a, 0);
		for (int i = 1; i <= 9; i++) {
			if (!stat[i]) {
				stat[i] = true;
				dfs_a(u + 1, a * 10 + i);
				stat[i] = false;
			}
		}
	}

	private static void dfs_c (int u, int a, int c) {
		if (u > 9) return;
		if (check_b(a, c)) ans++;
		for (int i = 1; i <= 9; i++) {
			if (!stat[i]) {
				stat[i] = true;
				dfs_c(u + 1, a, c * 10 + i);
				stat[i] = false;
			}
		}
	}

	private static boolean check_b (int a, int c) {
		long b = n * (long) c - (long) a * c;
		if (a == 0 || b == 0 || c == 0) return false;
		System.arraycopy(stat, 0, copy, 0, N);
		while (b > 0) {
			int x = (int) (b % 10);
			b /= 10;
			if (x == 0 || copy[x]) return false;
			copy[x] = true;
		}
		for (int i = 1; i <= 9; i++) {
			if (!copy[i]) return false;
		}
		return true;
	}
}
