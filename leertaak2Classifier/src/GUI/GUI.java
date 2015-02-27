package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


import classifier.*;

public class GUI implements ActionListener {
    private JButton submit;
    private JLabel status;
    private JRadioButton radioButtonYes1, radioButtonNo1, radioButtonYes2, radioButtonNo2;
    private JRadioButton radioButtonRed, radioButtonBlack, radioButtonWhite, radioButtonBlue, radioButtonGreen, radioButtonSilver;
    private String answer1, answer2;
    private String answer3 = "", answerString3;
    private Fuzzy fuzzy;

    public static void main(String[] args){
        new GUI();
    }

    /**
     * @param
     */
    public GUI() {
        makeFrame();

        fuzzy = new Fuzzy();
    }

    public void makeFrame(){
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setTitle("Auto Classifier");
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        status = new JLabel();

        JPanel questionsPanel = new JPanel();
        questionsPanel.setLayout(new GridLayout(5,1,5,5));

        // question 1
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(1,2));
        JPanel question1Panel = new JPanel();
        question1Panel.setLayout(new FlowLayout());
        JLabel question1 = new JLabel();
        question1Panel.add(question1);
        question1.setText("Heeft de auto airco?");

        radioButtonYes1 = new JRadioButton("yes");
        radioButtonYes1.addActionListener(this);
        radioButtonNo1 = new JRadioButton("no");
        radioButtonNo1.addActionListener(this);

        ButtonGroup radioButtonGroup1 = new ButtonGroup();
        radioButtonGroup1.add(radioButtonYes1);
        radioButtonGroup1.add(radioButtonNo1);

        question1Panel.add(question1);
        buttonPanel1.add(radioButtonYes1);
        buttonPanel1.add(radioButtonNo1);
        question1Panel.add(buttonPanel1);

        //question 2
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new GridLayout(1,2));
        JPanel question2Panel = new JPanel();
        question2Panel.setLayout(new FlowLayout());
        JLabel question2 = new JLabel();
        question2Panel.add(question2);
        question2.setText("Heeft de auto ABS?");

        radioButtonYes2 = new JRadioButton("yes");
        radioButtonYes2.addActionListener(this);
        radioButtonNo2 = new JRadioButton("no");
        radioButtonNo2.addActionListener(this);

        ButtonGroup radioButtonGroup2 = new ButtonGroup();
        radioButtonGroup2.add(radioButtonYes2);
        radioButtonGroup2.add(radioButtonNo2);

        question2Panel.add(question2);
        buttonPanel2.add(radioButtonYes2);
        buttonPanel2.add(radioButtonNo2);
        question2Panel.add(buttonPanel2);

        //question 3
        JPanel buttonPanel3 = new JPanel();
        buttonPanel3.setLayout(new GridLayout(1,2));
        JPanel question3Panel = new JPanel();
        question3Panel.setLayout(new FlowLayout());
        JLabel question3 = new JLabel();
        question3Panel.add(question3);
        question3.setText("Welk kleur heeft U auto?");

        radioButtonRed = new JRadioButton("red");
        radioButtonRed.addActionListener(this);
        radioButtonBlack = new JRadioButton("black");
        radioButtonBlack.addActionListener(this);
        radioButtonWhite = new JRadioButton("white");
        radioButtonWhite.addActionListener(this);
        radioButtonBlue = new JRadioButton("blue");
        radioButtonBlue.addActionListener(this);
        radioButtonGreen = new JRadioButton("green");
        radioButtonGreen.addActionListener(this);
        radioButtonSilver = new JRadioButton("silver");
        radioButtonSilver.addActionListener(this);

        ButtonGroup radioButtonGroup3 = new ButtonGroup();
        radioButtonGroup3.add(radioButtonRed);
        radioButtonGroup3.add(radioButtonBlack);
        radioButtonGroup3.add(radioButtonWhite);
        radioButtonGroup3.add(radioButtonBlue);
        radioButtonGroup3.add(radioButtonGreen);
        radioButtonGroup3.add(radioButtonSilver);
        question3Panel.add(question3);
        buttonPanel3.add(radioButtonRed);
        buttonPanel3.add(radioButtonBlack);
        buttonPanel3.add(radioButtonWhite);
        buttonPanel3.add(radioButtonBlue);
        buttonPanel3.add(radioButtonGreen);
        buttonPanel3.add(radioButtonSilver);
        question3Panel.add(buttonPanel3);

        questionsPanel.add(question1Panel);
        questionsPanel.add(question2Panel);
        questionsPanel.add(question3Panel);

        questionsPanel.add(status);

        submit = new JButton("Toon resultaat");
        submit.addActionListener(this);
        questionsPanel.add(submit);

        frame.add(questionsPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

            FeatureType yn = new FeatureType("YesNo"
                    ,new String[]{"1","0"});
            FeatureType cn = new FeatureType("ColorNorm"
                    ,new String[]{"3","2","1","0"});
            String answerString1 = "";
            String answerString2 = "";
            if (radioButtonYes1.isSelected())
                answerString1 = "1";
            else if (radioButtonNo1.isSelected())
                answerString1 = "0";
            if (radioButtonYes2.isSelected())
                answerString2 = "1";
            else if (radioButtonNo2.isSelected())
                answerString2 = "0";

            if (!answerString1.isEmpty() && !answerString2.isEmpty() && !answer3.isEmpty()){
                Feature[] features = new Feature[]
                        { new Feature("AC",answerString1,yn),
                                new Feature("ABS",answerString2,yn),
                                new Feature("COLOR",answer3,cn),
                        };

                Item item = new Item("car",features);

                String answer4= "";
                if (answerString1 == "1" && answerString2 == "1")
                    answer4 = "High";
                else if(answerString1 == "1" && answerString2 == "0")
                    answer4 = "Middle";
                else if(answerString1 == "0" && answerString2 == "0")
                    answer4 = "Low";

                //String category = " Airco: "+answerString1+" ABS: "+answerString2+" Kleur: "+answerString3+" Tarief: ";
                String category = " Airco: " + answer1 + "   ABS: " + answer2 + "   Color: " + answerString3 + "   InsuranceRate: " + answer4;
                status.setText(category);
            }
        }
        else if (e.getSource() == radioButtonYes1){
            answer1 = "Yes";
        }
        else if (e.getSource() == radioButtonNo1){
            answer1 = "No";
        }
        else if (e.getSource() == radioButtonYes2){
            answer2 = "Yes";
        }
        else if (e.getSource() == radioButtonNo2){
            answer2 = "No";
        }
        else if (e.getSource() == radioButtonRed){
            answer3 = fuzzy.getFuzzyRules("red");
            answerString3 = "Red";
        }
        else if (e.getSource() == radioButtonBlack){
            answer3 = fuzzy.getFuzzyRules("black");
            answerString3 = "Black";
        }
        else if (e.getSource() == radioButtonWhite){
            answer3 = fuzzy.getFuzzyRules("white");
            answerString3 = "White";
        }
        else if (e.getSource() == radioButtonBlue){
            answer3 = fuzzy.getFuzzyRules("blue");
            answerString3 = "Blue";
        }
        else if (e.getSource() == radioButtonGreen){
            answer3 = fuzzy.getFuzzyRules("green");
            answerString3 = "Green";
        }
        else if (e.getSource() == radioButtonSilver){
            answer3 = fuzzy.getFuzzyRules("silver");
            answerString3 = "Silver";
        }
    }

    class Fuzzy{
        private int low, middle, high;

        public Fuzzy(){
            setFuzzyRules();
        }

        public void setFuzzyRules(){
            low = 0;
            middle = 1;
            high = 2;
        }

        public String getFuzzyRules(String color){
           if (color == "red" || color == "blue" || color == "green")
                return ""+high;
            else if (color == "silver" || color == "white")
                return ""+middle;
            else
                return ""+low;
        }
    }}