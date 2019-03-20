package jjj.arithmetic.methods;

import java.util.Random;

public class CreateShiZi {
	public void create(int m, int n, String[] fuHao, String[] strArray) {
		String str = "";
		//Scanner input = new Scanner(System.in);
		//符号数组
		/*
		 * String[] fuHao = {"+","-","*","/"};
		 
		 * System.out.println("请输入范围内的计算：");
		 * int m = input.nextInt();
		 * System.out.println("请输入要产生的题数：");
		 * int n = input.nextInt();
		*/
		
		//随机生成式子
		for (int i = 0; i < n; i++) {
			str = "";
			int[] arr1 = new int[n];
			int[] arr2 = new int[n];
			arr2[i] = (int)(Math.random()*m+1);
			for(int j = 0; j < (int)(Math.random()*10+1); j++) {
				int order = (int)(Math.random()*4);
				arr1[j] = (int)(Math.random()*m+1);
				str = str + arr1[j] + fuHao[order];
			}
			str = str + arr2[i];
			strArray[i] = str;
			System.out.println("第"+(i+1)+"题："+str);
			arr1 = null;
			arr2 = null;
		}
		System.out.println("\n");
	}
}
