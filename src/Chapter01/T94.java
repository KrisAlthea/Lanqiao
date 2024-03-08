package Chapter01;

import java.io.PrintWriter;
import java.util.Scanner;


public class T94 {
	static int n;
	static final int N = 10;
	static int[] stat = new int[N];
	static boolean[] used = new boolean[N];
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		dfs(1);
	}

	private static void dfs (int u) {
		if (u > n){
			PrintWriter out = new PrintWriter(System.out);
			for (int i = 1; i <= n; i++) {
				out.print(stat[i]+" ");
//				System.out.print(stat[i]+" ");
			}
			out.println();
			out.flush();
//			System.out.println();
			return;
		}
		for (int i = 1; i <= n;i++){
			if (!used[i]){
				stat[u] = i;
				used[i] = true;
				dfs(u+1);
				//恢复现场
				stat[u] = 0;
				used[i] = false;
			}
		}
	}
}
