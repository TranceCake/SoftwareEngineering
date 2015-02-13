package ui;

import multiformat.Calculator;
import multiformat.FormatException;
import multiformat.Rational;

import java.util.Stack;

/**
 * Controller for handling traffic from and to the GUI.
 */
public class CalculatorController {
    private Stack<String> st1 = new Stack<String>();
    private Stack<String> st2 = new Stack<String>();
    private Stack<String> st1Invert = new Stack<String>();
    private Stack<String> st2Invert = new Stack<String>();
    private boolean first = true;
    Calculator c;
    private String operator;


    /**
     * Reads input sent by actionListeners.
     * @param input information sent by actionListeners
     */
    public void readInput(String input) {
        if (first) {
            if (!input.equals("div") && !input.equals("mul") && !input.equals("sub") && input.equals("add")) {
                st1.push(input);
                first = false;
            }
        } else {
            st2.push(input);
        }
    }

    /**
     * sets the operator for doing calculations.
     * @param op the operator the user clicked on
     */
    public void setOperator(String op) {
        this.operator = op;
    }

    /**
     * reverses the stack so the numbers are in correct order.
     */
    public void preCalculate() {
        String temp;
        while(!st1.empty()) {
            temp = st1.pop();
            st1Invert.push(temp);
        }
        while(!st2.empty()) {
            temp = st2.pop();
            st2Invert.push(temp);
        }
        calculate();
    }

    /**
     * calls all the calculational functions.
     */
    public void calculate() {
        String op1 = "";
        String op2 = "";

        while(!st1Invert.empty()) {
            op1 += st1Invert.pop();
        }

        try {
            c.addOperand(op1);
        } catch (FormatException e) {
            e.printStackTrace();
        }

        while(!st2Invert.empty()) {
            op1 += st2Invert.pop();
        }

        try {
            c.addOperand(op2);
        } catch (FormatException e) {
            e.printStackTrace();
        }

        if(operator.equals("div")) {
            try {
                c.divide();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(operator.equals("mul")) {
            try {
                c.multiply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(operator.equals("sub")) {
            try {
                c.subtract();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(operator.equals("add")) {
            try {
                c.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
