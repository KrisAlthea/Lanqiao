package Chapter01;

import java.io.PrintWriter;
import java.util.Scanner;

public class T93 {
	static int m, n;
	public static final int N = 26;
	static int[] stat = new int[N];

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		dfs(1, 1);
	}

	private static void dfs (int u, int start) {
		//剪枝
		if (u + n - start < m) {
			return;
		}
		if (u > m) {
			PrintWriter out = new PrintWriter(System.out);
			for (int i = 1; i <= m; i++) {
				out.print(stat[i] + " ");
			}
			out.println();
			out.flush();
			return;
		}

		for (int i = start; i <= n; i++) {
			stat[u] = i;
			dfs(u + 1, i + 1);
		}
	}
}
