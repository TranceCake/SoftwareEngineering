package ui;

import multiformat.Calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Niek on 2/12/2015.
 */
public class OutputView extends JPanel {

    String answer;
    JTextArea ansField = new JTextArea();
    Calculator c;

    public OutputView() {
        this.setLayout(new FlowLayout());
        this.add(ansField);
        ansField.setEditable(false);
    }

    public void updateView(){
        //ansField.setText(answer);
        ansField.setText(c.firstOperand() + " " + c.secondOperand() + " - " + answer);
    }

    public void setText(String given){
        this.answer = given;
    }

}
