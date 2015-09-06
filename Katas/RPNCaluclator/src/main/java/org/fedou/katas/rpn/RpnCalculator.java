package org.fedou.katas.rpn;

public class RpnCalculator {
	enum Operator {
		PLUS("+") {
			public int operate(int op1, int op2) {
				return op1 + op2;
			}
		},
		SUB("-") {
			public int operate(int op1, int op2) {
				return op1 - op2;
			}
		},
		MULT("*") {
			public int operate(int op1, int op2) {
				return op1 * op2;
			}
		},
		DIV("/") {
			public int operate(int op1, int op2) {
				return op1 / op2;
			}
		};
		
		private String operator;

		private Operator(String operator) {
			this.operator = operator;
		}
		public abstract int operate(int firstOperand, int secondOperand);

		public static Operator parseOperator(String operatorToParse) {
			for (Operator oper : Operator.values()) {
				if (operatorToParse.equals(oper.operator)) {
					return oper;
				}
			}
			return null;
		}

	}

	public int calculate(String... expressions) {
		if (expressions.length == 1) {
			return Integer.parseInt(expressions[0]);
		}
		int firstOperand = Integer.parseInt(expressions[0]);
		int secondOperand = Integer.parseInt(expressions[1]);
		Operator op = Operator.parseOperator(expressions[2]);
		return op.operate(firstOperand, secondOperand);
	}
}
