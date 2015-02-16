package ui;

import multiformat.Calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Initiates the applet and adds the views
 * Created by Niek on 2/12/2015.
 */
public class CalculatorMVC extends JApplet{

    ButtonView buttonView;
    CalculatorController controller;
    Calculator c;

    /**
     * initiates the applet
     */
    public void init() {

        //sets the look and feel of the applet.
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

    }
}
