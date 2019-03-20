package jjj.arithmetic.methods;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;

public class NiBoLanShi {
	public static String cal(String str) {
		//�Ա��ʽ����Ԥ����������֤�Ƿ�����ȷ�ı��ʽ
		//��Ŵ����ı��ʽ
		List<String> list = new ArrayList<>();
		char[] arr = str.toCharArray();
		
		//���������ʱ����
		StringBuffer tmpStr = new StringBuffer();
		for (char c : arr) {
			//��������ֻ�С���㣬��ӵ���ʱ������
			if (c>='0' && c<='9') {
				tmpStr.append(c);
			}else if(c=='.') {
				if(tmpStr.indexOf(".")>0) {
					throw new RuntimeException("�Ƿ��ַ�");
				}
				tmpStr.append(c);
			}
			
			//����ǼӼ��˳��������ţ���������ʱ��������������η���List��
			else if (c=='+' || c=='-' || c=='*' || c=='/' || c=='(' || c==')') {
				if (tmpStr.length() > 0) {
					list.add(tmpStr.toString());
					tmpStr.setLength(0);
				}
				list.add(c + "");
			}
			else if (c==' ') {
				continue;
			}
			else {
				throw new RuntimeException("�Ƿ��ַ�");
			}
		}
		if (tmpStr.length() > 0) {
			list.add(tmpStr.toString());
		}
		
		//��ʼ����׺���ʽ
		List<String> strList = new ArrayList<>();
		
		//��������У�ʹ��������ջ�ṹ��
		//��һ���ǽ���׺���ʽת���ɺ�׺���ʽ���ڶ����Ǽ����׺���ʽ��ֵ
		Stack<String> stack = new Stack<>();
		
		//������ʱ���������ջԪ��
		String tmp;
		
		//����׺���ʽת���ɺ�׺���ʽ
		for (String s : list) {
			//�����������ֱ����ջ
			if (s.equals("(")) {
				stack.push(s);
			}
			
			//����������ţ�ִ�г�ջ������������ӵ���׺���ʽ�У�ֱ����ջԪ��Ϊ�����ţ������ź������Ŷ�����ӵ���׺���ʽ��
			else if (s.equals(")")) {
				while (!(tmp = stack.pop()).equals("(")) {
					strList.add(tmp);					
				}
			}
			
			//����ǼӼ��˳��������������ȼ����ڻ���ڸ��������ջ��Ԫ�أ�ջ�п϶�û�������ţ���Ϊ�����ŵ����ȼ���ͣ���Ȼ�󽫸��������ջ
			else if (s.equals("*") || s.equals("/")) {
				while(!stack.isEmpty()) {
					//ȡ��ջ��Ԫ��
					tmp = stack.peek();//ȡ�������Ƴ�
					if (tmp.equals("*") || tmp.equals("/")) {
						stack.pop();
						strList.add(tmp);
					}
					else {
						break;
					}
				}
				stack.push(s);
			}
			else if (s.equals("+") || s.equals("-")) {
				while(!stack.isEmpty()) {
					//ȡ��ջ��Ԫ��
					tmp = stack.peek();
					if (!tmp.equals("(")) {
						stack.pop();
						strList.add(tmp);
					}
					else {
						break;
					}
				}
				stack.push(s);
			}
			
			//��������֣�ֱ����ӵ���׺���ʽ��
			else {
				strList.add(s);
			}
		}
		
		//������γ�ջ�������׺���ʽ��
		while (!stack.isEmpty()) {
			strList.add(stack.pop());
		}
		
		//�����׺���ʽ��ֵ
		Stack<BigDecimal> newStack = new Stack<>();
		for (String s : strList) {
			//��������������ջ���˳�����Ԫ�أ����˳��ķŵ���������ұߣ����˳��ķŵ�����������
			//�����Ľ���ٽ�ջ��ֱ����׺���ʽ�������
			if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
				BigDecimal b1 = newStack.pop();
				BigDecimal b2 = newStack.pop();
				switch (s) {
				case "+":
					newStack.push(b2.add(b1));
					break;
				case "-":
					newStack.push(b2.subtract(b1));
					break;
				case "*":
					newStack.push(b2.multiply(b1));
					break;
				case "/":
					newStack.push(b2.divide(b1, 9, BigDecimal.ROUND_HALF_UP));
					break;
				}
			}
			
			//��������֣���ջ
			else {
				newStack.push(new BigDecimal(s));
			}
		}
		
		//���ջ�н���һ��Ԫ�أ����Ǽ�����
		return newStack.peek().toString();
	}
}
