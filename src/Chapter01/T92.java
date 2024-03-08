package Chapter01;

import java.util.Scanner;

public class T92 {
	public static final int N = 16;
	static int n;
	static int cnt;
	static int[] stat = new int[N];
	static int[][] solutions = new int[1<<15][N];
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		dfs(1);
	}

	private static void dfs (int i) {
		if (i > n){
			for (int j = 1; j <= n; j++) {
				if (stat[j] == 1){
					System.out.print(j+" ");
				}
			}
			System.out.println();
			return;
		}
		//第一种情况：不访问
		stat[i] = 2;
		dfs(i+1);
		//第二种情况：访问
		stat[i] = 1;
		dfs(i+1);
		//恢复现场
		stat[i] = 0;
	}
}
