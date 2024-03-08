package Chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T95 {
	static char[][] g = new char[5][5];
	static char[][] ng;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 0}, {0, 1}, {0, -1}};

	public static void turn (int i, int j) {
		for (int[] dir : dirs) {
			int ni = i + dir[0], nj = j + dir[1];
			if (ni < 0 || ni >= 5 || nj < 0 || nj >= 5) continue;   // 在边界外，直接忽略即可
			//ng[ni][nj] ^= 1;  //'0'和'1'的ascii 48 49 就差最后一位不一样，因此异或一个1即可 ^=1
			if (ng[ni][nj] == '0') ng[ni][nj] = '1';
			else ng[ni][nj] = '0';
		}
	}

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int a = 0; a < n; a++) {
			//单行
			for (int i = 0; i < 5; i++) {
				g[i] = br.readLine().toCharArray();
			}
			int res = 7;


			//初始化第一行，因为只有5个开关 2^5=32种情况 5位2进制表示每一盏灯的情况
			outer:
			for (int i = 0; i < 32; i++) {
				//注意二维数组深拷贝
				ng = g.clone();
				for (int j = 0; j < 5; j++) {
					ng[j] = g[j].clone();
				}

				int step = 0;
				//初始化第一行
				for (int j = 0; j < 5; j++) {
					if ((i >> j & 1) == 0) {
						step++;
						turn(0, j);
					}
				}

				//从第二行开始，上一行不亮则需要下一行turn
				for (int j = 1; j < 5; j++) {
					for (int m = 0; m < 5; m++) {
						if (ng[j - 1][m] == '0') {
							step++;
							if (step > 6) {
								continue outer;
							}
							turn(j, m);
						}
					}
				}

				//判断最终结果，即最后一行有没有全部点亮
				boolean dark = false;
				for (int m = 0; m < 5; m++) {
					if (ng[4][m] == '0') {
						dark = true;
						break;
					}
				}
				if (!dark) {
					res = Integer.min(step, res);
				}
			}
			System.out.println(res == 7 ? -1 : res);
			br.readLine();
		}
	}
}