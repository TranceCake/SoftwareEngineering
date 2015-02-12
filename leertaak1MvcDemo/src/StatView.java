import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StatView extends JPanel implements ActionListener {
    int numOfRolls;
    int timesOne = 0;
    int timesTwo = 0;
    int timesThree = 0;
    int timesFour = 0;
    int timesFive = 0;
    int timesSix = 0;

    private JLabel oneCount = new JLabel();
    private JLabel twoCount = new JLabel();
    private JLabel threeCount = new JLabel();
    private JLabel fourCount = new JLabel();
    private JLabel fiveCount = new JLabel();
    private JLabel sixCount = new JLabel();
    private JLabel rollCount =  new JLabel();

    DobbelsteenModel d;

    public StatView()
    {
        this.setLayout(new GridLayout(0,1));
        this.add(oneCount);
        this.add(twoCount);
        this.add(threeCount);
        this.add(fourCount);
        this.add(fiveCount);
        this.add(sixCount);
        this.add(rollCount);
    }

    public void actionPerformed( ActionEvent e ) {
        d = (DobbelsteenModel) e.getSource();
        int num = d.getWaarde();
        this.updateStats(num);
    }

    public void updateStats(int value) {
        if(value == 1) {
            timesOne++;
            oneCount.setText("One: "+timesOne+"x");
        } else if(value == 2) {
            timesTwo++;
            twoCount.setText("Two: "+timesTwo+"x");
        } else if(value == 3) {
            timesThree++;
            threeCount.setText("Three: "+timesThree+"x");
        } else if(value == 4) {
            timesFour++;
            fourCount.setText("Four: "+timesFour+"x");
        } else if(value == 5) {
            timesFive++;
            fiveCount.setText("Five: "+timesFive+"x");
        } else if(value == 6) {
            timesSix++;
            sixCount.setText("Six: "+timesSix+"x");
        } else {
            oneCount.setText("One: "+timesOne+"x");
            twoCount.setText("Two: "+timesTwo+"x");
            threeCount.setText("Three: "+timesThree+"x");
            fourCount.setText("Four: "+timesFour+"x");
            fiveCount.setText("Five: "+timesFive+"x");
            sixCount.setText("Six: "+timesSix+"x");
            return;
        }

        numOfRolls++;
        rollCount.setText("Times Rolled: "+numOfRolls);

    }

    public Dimension getPreferredSize()
    {
        return new Dimension(100,50);
    }

}
