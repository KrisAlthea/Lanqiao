package Chapter01;

import java.util.Scanner;

public class T717 {
	public static final int N = 50;

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] fibonacci = new int[N];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
		}
		for (int i = 0; i < n; i++) {
			System.out.print(fibonacci[i] + " ");
		}

		/*//优化空间
		int a = 0;
		int b = 1;
		for (int i = 1; i <= n; i++) {
			System.out.println(a);
			int fn = a + b;
			a = b;
			b = fn;
		}*/

	}
}
