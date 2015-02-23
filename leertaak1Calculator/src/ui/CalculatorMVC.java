package ui;

import multiformat.Calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Niek on 2/12/2015.
 */
public class CalculatorMVC extends JApplet{

    ButtonView buttonView;
    CalculatorController controller;
    Calculator c;

    OutputView outputView;

    public void init() {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }

        controller = new CalculatorController();
        c = new Calculator();
        buttonView = new ButtonView(controller, c);
        buttonView.setBackground(Color.white);
        getContentPane().add(buttonView,BorderLayout.SOUTH);
        outputView = new OutputView();
        outputView.setBackground(Color.white);
        getContentPane().add(outputView,BorderLayout.NORTH);
    }
}
