# 蓝桥杯

## 一、递归与递推

> 递归：函数自己调用自己，把一个问题分解为若干个同类型的问题
>
> 递推：先解决子问题，之后解决问题

例：斐波那契数列（还可以写成递推）

`f(1) = 0, f(2) = 1, f(n) = f(n-1) + f(n-2);`

[求解斐波那契数列的若干方法 - AcWing](https://www.acwing.com/file_system/file/content/whole/index/content/3067/)

- 递归或DFS最重要的是**顺序**，

每个递归都有一个**递归搜索树**

### T95

- 关于改变'0'和'1'，可以与“1”进行与运算&，0的ASCII码为48，二进制是11000。

- 偏移量的应用。dx={-1，0，1，0，0}，dy={0，1，0，-1，0}

## ToDo

T95理解思路

## 笔记

### 高性能输入输出

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Main { 
	public static void main(String[] args) throws NumberFormatException, IOException {
		//高性能输入，用于数据量大，要求输入输出速度快
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
        
		int i=Integer.parseInt(in.readLine());           //int型输入
		long l=Long.parseLong(in.readLine());            //long型输入
		float f=Float.parseFloat(in.readLine());         //float型输入
		double d=Double.parseDouble(in.readLine());      //double型输入
		String s=in.readLine();                          //String型输入
		BigInteger b=new BigInteger(in.readLine());      //BigInteger型输入
		
		//输出
		out.println(i);
		out.println(l);
		out.println(f);
		out.println(d);
		out.println(s);
		out.println(b);
		
		//关闭输出，每次输入后一定要关闭
        out.flush();
	}
}

```

