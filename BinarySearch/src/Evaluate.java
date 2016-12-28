import java.util.ArrayList;
import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
	public double caculate(String s) {
		Stack<Character> operator = new Stack<>();
		Stack<Double> numbers = new Stack<>();
		char[] charArray = s.toCharArray();
		ArrayList<Character> temp = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++) {
			if ((charArray[i] <= '9' && charArray[i] >= '0')
					|| charArray[i] == '.') {
				temp.add(charArray[i]);
				if (i == charArray.length - 1) {
					numbers.push(getNum(temp));
				}
			} else {
				if (temp.size() != 0) {
					numbers.push(getNum(temp));
					temp.clear();
				}
				if (charArray[i] == '(') {

				} else if (charArray[i] == ')') {
					if (numbers.size() == 1)
						return numbers.pop();
					char op = operator.pop();
					double a = numbers.pop();// ������ʱ�������⣬�����ͳ���a-b��Ӧ��������վ������վ
					double b = numbers.pop();
					doCalcu(op, a, b, numbers);
				} else {
					operator.push(charArray[i]);
				}
			}
		}
		Stack<Character> lastOperater = new Stack<>();
		Stack<Double> lastNumbers = new Stack<>();

		while (!operator.empty()) {//��Ϊ�г˳�������û�������ˣ����Բ��ᰴ�����ȼ������㣬���ԣ��½�����ջ��ϣ�������ֻʣ�Ӽ����ļ���
			char op = operator.pop();
			if (op == '+' || op == '-') {
				lastOperater.push(op);//���Ӽ�����ֱ��popһ��������push��վ����
				lastNumbers.push(numbers.pop());
			} else {
				double a = numbers.pop();//��˳�������pop��������Ȼ����numbersջ
				double b = numbers.pop();
				numbers.push(doCalcu(op, a, b));
			}
		}
		lastNumbers.push(numbers.pop());
		while(!lastOperater.empty()){
			char op = lastOperater.pop();
			double a = lastNumbers.pop();
			double b = lastNumbers.pop();
			doCalcu(op, a, b, lastNumbers);
		}
		return lastNumbers.pop();

	}

	public void doCalcu(char op, double a, double b, Stack<Double> numbers) {
		double c = 0;
		if (op == '+')
			c = (b + a);
		else if (op == '*')
			c = (b * a);
		else if (op == '/')
			c = (b / a);
		else if (op == '-')
			c = (b - a);
		numbers.push(c);
	}

	public double doCalcu(char op, double a, double b) {
		double c = 0;
		if (op == '+')
			c = (b + a);
		else if (op == '*')
			c = (b * a);
		else if (op == '/')
			c = (b / a);
		else if (op == '-')
			c = (b - a);
		return c;
	}

	public double getNum(ArrayList<Character> temp) {
		char[] numchar = new char[temp.size()];
		for (int j = 0; j < temp.size(); j++) {
			numchar[j] = temp.get(j);
		}
		double num = Double.parseDouble(String.valueOf(String
				.copyValueOf(numchar)));
		return num;
	}

	public static void main(String[] args) {
		Evaluate e = new Evaluate();
		StdOut.print(e.caculate("(1+1)+(2/3)*(3-1)+1.2"));
	}
}