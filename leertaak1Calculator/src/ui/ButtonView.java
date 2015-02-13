package ui;

import multiformat.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * dingen
 */
public class ButtonView extends JPanel implements ActionListener {

    Calculator c;
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
    private JButton dot = new JButton(".");
    private JButton div = new JButton("/");
    private JButton mul = new JButton("*");
    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton res = new JButton("=");


    public ButtonView() {
        this.setLayout(new GridLayout(4,6));
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
        this.add(dot);
        dot.addActionListener(this);
        this.add(b0);
        b0.addActionListener(this);
        this.add(res);
        res.addActionListener(this);
        this.add(add);
        add.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)
        {
            //
        }
        if (e.getSource() == b2)
        {
            //
        }
        if (e.getSource() == b3)
        {
            //
        }
        if (e.getSource() == b4)
        {
            //
        }
        if (e.getSource() == b5)
        {
            //
        }
        if (e.getSource() == b6)
        {
            //
        }
        if (e.getSource() == b7)
        {
            //
        }
        if (e.getSource() == b8)
        {
            //
        }
        if (e.getSource() == b9)
        {
            //
        }
        if (e.getSource() == b0)
        {
            //
        }
        if (e.getSource() == dot)
        {
            //
        }
        if (e.getSource() == div)
        {
            //
        }
        if (e.getSource() == mul)
        {
            //
        }
        if (e.getSource() == add)
        {
            //
        }
        if (e.getSource() == sub)
        {
            //
        }
        if (e.getSource() == res)
        {
            //
        }



    }
}
