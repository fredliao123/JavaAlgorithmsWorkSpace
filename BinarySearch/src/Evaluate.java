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
					double a = numbers.pop();// 减法的时候会出问题，这样就成了a-b，应该是先入站减后入站
					double b = numbers.pop();
					doCalcu(op, a, b, numbers);
				} else {
					operator.push(charArray[i]);
				}
			}
		}
		Stack<Character> lastOperater = new Stack<>();
		Stack<Double> lastNumbers = new Stack<>();

		while (!operator.empty()) {//因为有乘除法，又没有括号了，所以不会按照优先级来计算，所以，新建两个栈，希望存的是只剩加减法的计算
			char op = operator.pop();
			if (op == '+' || op == '-') {
				lastOperater.push(op);//遇加减法，直接pop一个数，再push入站即可
				lastNumbers.push(numbers.pop());
			} else {
				double a = numbers.pop();//与乘除法，则pop两个数，然后入numbers栈
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