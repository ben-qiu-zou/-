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
		System.out.println("�����뷶Χ�ڵļ��㣺");
		int m = input.nextInt();
		System.out.println("������Ҫ������������");
		int n = input.nextInt();
		String[] strArray = new String[n];
		System.out.println("\n��Ŀ\n");
		createShiZi.create(m, n, fuHao, strArray);
		for(int i = 0; i<n; i++) {
			String result = niBoLanShi.cal(strArray[i]);
			System.out.println("��"+(i+1)+"�⣺"+strArray[i]);
			System.out.print("��Ĵ𰸣�");
			String yourAnswer = input.next();
			if (yourAnswer.equals(result)) {
				System.out.println("True\n");
			}else {
				System.out.println("False");
				System.out.println("��ȷ�𰸣�"+result+"\n");
			}
		}
	}
}
