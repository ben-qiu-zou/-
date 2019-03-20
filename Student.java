package jjj.arithmetic.texts;

import java.util.Scanner;


import jjj.arithmetic.methods.CreateShiZi;
import jjj.arithmetic.methods.NiBoLanShi;

public class Student {

	public static void main(String[] args) {
		CreateShiZi createShiZi = new CreateShiZi();
		NiBoLanShi niBoLanShi = new NiBoLanShi();
		String[] fuHao = {"+","-","*","/"};
		Scanner input = new Scanner(System.in);
		System.out.println("请输入范围内的计算：");
		int m = input.nextInt();
		System.out.println("请输入要产生的题数：");
		int n = input.nextInt();
		String[] strArray = new String[n];
		System.out.println("\n题目\n");
		createShiZi.create(m, n, fuHao, strArray);
		for(int i = 0; i<n; i++) {
			String result = niBoLanShi.cal(strArray[i]);
			System.out.println("第"+(i+1)+"题："+strArray[i]);
			System.out.print("你的答案：");
			String yourAnswer = input.next();
			if (yourAnswer.equals(result)) {
				System.out.println("True\n");
			}else {
				System.out.println("False");
				System.out.println("正确答案："+result+"\n");
			}
		}
	}
}
