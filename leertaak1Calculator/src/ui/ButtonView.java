package ui;

import multiformat.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * dingen
 */
public class ButtonView extends JPanel implements ActionListener {

    OutputView output;
    CalculatorController controller;
    Calculator c;

    private JRadioButton r1 = new JRadioButton("Binary");
    private JRadioButton r2 = new JRadioButton("Octal");
    private JRadioButton r3 = new JRadioButton("Decimal");
    private JRadioButton r4 = new JRadioButton("Hexadecimal");

    private JButton b1 = new JButton("1");
    private JButton b2 = new JButton("2");
    private JButton b3 = new JButton("3");
    private JButton b4 = new JButton("4");
    private JButton b5 = new JButton("5");
    private JButton b6 = new JButton("6");
    private JButton b7 = new JButton("7");
    private JButton b8 = new JButton("8");
    private JButton b9 = new JButton("9");
    private JButton b0 = new JButton("0");
    private JButton bA = new JButton("A");
    private JButton bB = new JButton("B");
    private JButton bC = new JButton("C");
    private JButton bD = new JButton("D");
    private JButton bE = new JButton("E");
    private JButton bF = new JButton("F");
    private JButton cl = new JButton("C");
    private JButton div = new JButton("/");
    private JButton mul = new JButton("*");
    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton res = new JButton("=");

    private JButton cl;
    private JButton div;
    private JButton mul;
    private JButton add;
    private JButton sub;
    private JButton res;

    private String toShow;

    /**
     * Constructor for ButtonView initiates all buttons and adds actionlisteners to them.
     */
    public ButtonView(CalculatorController controller, Calculator c) {

        toShow = "";
        this.c = c;
        this.controller = controller;

        ansField = new JTextArea();
        this.add(new JPanel());
        this.add(new JPanel());
        this.add(new JPanel());
        this.add(ansField);
        ansField.setEditable(false);

        this.setLayout(new GridLayout(8,4));
        r1 = new JRadioButton("Binary");
        r2 = new JRadioButton("Octal");
        r3 = new JRadioButton("Decimal");
        r4 = new JRadioButton("Hexadecimal");

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");

        bA = new JButton("A");
        bB = new JButton("B");
        bC = new JButton("C");
        bD = new JButton("D");
        bE = new JButton("E");
        bF = new JButton("F");

        cl = new JButton("Clear");
        div = new JButton("/");
        mul = new JButton("*");
        add = new JButton("+");
        sub = new JButton("-");
        res = new JButton("=");

    public ButtonView() {
        this.setLayout(new GridLayout(5,4));
        this.add(r1);
        r1.addActionListener(this);
        this.add(r2);
        r2.addActionListener(this);
        this.add(r3);
        r3.addActionListener(this);
        this.add(r4);
        r4.addActionListener(this);

        this.add(bD);
        bD.addActionListener(this);
        this.add(bE);
        bE.addActionListener(this);
        this.add(bF);
        bF.addActionListener(this);
        this.add(cl);
        cl.addActionListener(this);

        this.add(bA);
        bA.addActionListener(this);
        this.add(bB);
        bB.addActionListener(this);
        this.add(bC);
        bC.addActionListener(this);
        this.add(div);
        div.addActionListener(this);

        this.add(b7);
        b7.addActionListener(this);
        this.add(b8);
        b8.addActionListener(this);
        this.add(b9);
        b9.addActionListener(this);
        this.add(div);
        div.addActionListener(this);
        this.add(b4);
        b4.addActionListener(this);
        this.add(b5);
        b5.addActionListener(this);
        this.add(b6);
        b6.addActionListener(this);
        this.add(mul);
        mul.addActionListener(this);
        this.add(b1);
        b1.addActionListener(this);
        this.add(b2);
        b2.addActionListener(this);
        this.add(b3);
        b3.addActionListener(this);
        this.add(sub);
        sub.addActionListener(this);
        this.add(b0);
        b0.addActionListener(this);
        this.add(cl);
        cl.addActionListener(this);
        this.add(res);
        res.addActionListener(this);
        this.add(add);
        add.addActionListener(this);

        ButtonGroup bases = new ButtonGroup();
        bases.add(r1);
        bases.add(r2);
        bases.add(r3);
        bases.add(r4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            controller.readInput("1");
            answer = "1";
            makeText("1");
            output.setText("1");
        } else if (e.getSource() == b2) {
            controller.readInput("2");
            makeText("2");
        } else if (e.getSource() == b3) {
            controller.readInput("3");
            makeText("3");
        } else if (e.getSource() == b4) {
            controller.readInput("4");
            makeText("4");
        } else if (e.getSource() == b5) {
            controller.readInput("5");
            makeText("5");
        } else if (e.getSource() == b6) {
            controller.readInput("6");
            makeText("6");
        } else if (e.getSource() == b7) {
            controller.readInput("7");
            makeText("7");
        } else if (e.getSource() == b8) {
            controller.readInput("8");
            makeText("8");
        } else if (e.getSource() == b9) {
            controller.readInput("9");
            makeText("9");
        } else if (e.getSource() == b0) {
            controller.readInput("0");
            makeText("0");
        } else if (e.getSource() == bA) {
            controller.readInput("A");
            makeText("A");
        } else if (e.getSource() == bB) {
            controller.readInput("B");
            makeText("B");
        } else if (e.getSource() == bC) {
            controller.readInput("C");
            makeText("C");
        } else if (e.getSource() == bD) {
            controller.readInput("D");
            makeText("D");
        } else if (e.getSource() == bE) {
            controller.readInput("E");
            makeText("E");
        } else if (e.getSource() == bF) {
            controller.readInput("F");
            makeText("F");
        } else if (e.getSource() == div) {
            controller.setOperator("div");
            makeText("/");
        } else if (e.getSource() == mul) {
            controller.setOperator("mul");
            makeText("*");
        } else if (e.getSource() == add) {
            controller.setOperator("add");
            makeText("+");
        } else if (e.getSource() == sub) {
            controller.setOperator("sub");
            makeText("-");
        } else if (e.getSource() == res) {
            controller.preCalculate();
            makeText("=");
        } else if (e.getSource() == r1) {
            c.setBase(new BinaryBase());
            setBinary();
        } else if (e.getSource() == r2) {
            c.setBase(new OctalBase());
            setOctal();
        } else if (e.getSource() == r3) {
            c.setBase(new DecimalBase());
            setDecimal();
        } else if (e.getSource() == r4) {
            c.setBase(new HexBase());
            setHex();
        }
    }
    public void makeText(String input){

        toShow += input;
        ansField.setText(toShow);
    }

    /**
     * disabelling buttons that are not used/permitted in binary base.
     */
    public void setBinary() {
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);
        bD.setEnabled(false);
        bE.setEnabled(false);
        bF.setEnabled(false);
        output.updateView();
        repaint();
    }

    public void setOctal() {
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(false);
        b9.setEnabled(false);
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);
        bD.setEnabled(false);
        bE.setEnabled(false);
        bF.setEnabled(false);
        output.updateView();
        repaint();
    }

    public void setDecimal() {
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);
        bD.setEnabled(false);
        bE.setEnabled(false);
        bF.setEnabled(false);
        output.updateView();
        repaint();
    }

    public void setHex() {
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(false);
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);
        bD.setEnabled(false);
        bE.setEnabled(false);
        bF.setEnabled(false);
        output.updateView();
        repaint();
    }
}
