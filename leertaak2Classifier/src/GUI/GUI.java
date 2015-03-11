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
   // private DecisionTree tree;
    private Fuzzy fuzzy;

    public static void main(String[] args){
        new GUI();
    }

    /**
     * @param
     */
    public GUI() {
        makeFrame();
   //     makeTree();
        fuzzy = new Fuzzy();
    }

    public void makeFrame(){
        GUI = new JFrame();
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.getContentPane().setLayout(null);

        lblTurbo = new JLabel("Heeft de auto Turbo?");
        lblTurbo.setBounds(10, 11, 181, 14);
        frmSimplegui.getContentPane().add(lblTurbo);

        rdbtnJa1 = new JRadioButton("Ja");
        rdbtnJa1.setBounds(6, 32, 63, 23);
        GUI.getContentPane().add(rdbtnJa1);

        rdbtnNee1 = new JRadioButton("Nee");
        rdbtnNee1.setBounds(82, 32, 109, 23);
        GUI.getContentPane().add(rdbtnNee1);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(rdbtnJa1);
        group1.add(rdbtnNee1);

        lblEngin = new JLabel("Heeft de auto EnginPower?");
        lblEngin.setBounds(10, 69, 181, 14);
        lblEngin.setVisible(false);
        GUI.getContentPane().add(lblEngin);

        rdbtnJa2 = new JRadioButton("Ja");
        rdbtnJa2.setBounds(10, 90, 63, 23);
        rdbtnJa2.setVisible(false);
        GUI.getContentPane().add(rdbtnJa2);

        rdbtnNee2 = new JRadioButton("Nee");
        rdbtnNee2.setBounds(82, 90, 109, 23);
        rdbtnNee2.setVisible(false);
        GUI.getContentPane().add(rdbtnNee2);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(rdbtnJa2);
        group2.add(rdbtnNee2);

        lblSportBum = new JLabel("Heeft de auto SportBumper?");
        lblSportBum.setBounds(14, 116, 181, 14);
        lblSportBum.setVisible(false);
        GUI.getContentPane().add(lblSportBum);

        rdbtnJa3 = new JRadioButton("Ja");
        rdbtnJa3.setBounds(10, 137, 63, 23);
        rdbtnJa3.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnJa3);

        rdbtnNee3 = new JRadioButton("Nee");
        rdbtnNee3.setBounds(82, 137, 109, 23);
        rdbtnNee3.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnNee3);

        ButtonGroup group3 = new ButtonGroup();
        group3.add(rdbtnJa3);
        group3.add(rdbtnNee3);

        lblSportR = new JLabel("Heeft de auto SportRing?");
        lblSportR.setBounds(10, 163, 181, 14);
        lblSportR.setVisible(false);
        frmSimplegui.getContentPane().add(lblSportR);

        rdbtnJa4 = new JRadioButton("Ja");
        rdbtnJa4.setBounds(10, 184, 63, 23);
        rdbtnJa4.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnJa4);

        rdbtnNee4 = new JRadioButton("Nee");
        rdbtnNee4.setBounds(82, 184, 109, 23);
        rdbtnNee4.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnNee4);

        ButtonGroup group4 = new ButtonGroup();
        group4.add(rdbtnJa4);
        group4.add(rdbtnNee4);

        lblCruis = new JLabel("Heeft de auto CruisControll?");
        lblCruis.setBounds(14, 210, 181, 14);
        lblCruis.setVisible(false);
        frmSimplegui.getContentPane().add(lblCruis);

        rdbtnJa5 = new JRadioButton("Ja");
        rdbtnJa5.setBounds(10, 231, 63, 23);
        rdbtnJa5.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnJa5);

        rdbtnNee5 = new JRadioButton("Nee");
        rdbtnNee5.setBounds(82, 231, 109, 23);
        rdbtnNee5.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnNee5);

        ButtonGroup group5 = new ButtonGroup();
        group5.add(rdbtnJa5);
        group5.add(rdbtnNee5);

        lblABS = new JLabel("Heeft de auto ABS?");
        lblABS.setBounds(10, 257, 181, 14);
        lblABS.setVisible(false);
        frmSimplegui.getContentPane().add(lblABS);

        rdbtnJa6 = new JRadioButton("Ja");
        rdbtnJa6.setBounds(10, 278, 63, 23);
        rdbtnJa6.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnJa6);

        rdbtnNee6 = new JRadioButton("Nee");
        rdbtnNee6.setBounds(82, 278, 109, 23);
        rdbtnNee6.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnNee6);

        ButtonGroup group6 = new ButtonGroup();
        group6.add(rdbtnJa6);
        group6.add(rdbtnNee6);

        lblAC = new JLabel("Heeft de auto AC?");
        lblAC.setBounds(10, 304, 181, 14);
        lblAC.setVisible(false);
        frmSimplegui.getContentPane().add(lblAC);

        rdbtnJa7 = new JRadioButton("Ja");
        rdbtnJa7.setBounds(10, 325, 63, 23);
        rdbtnJa7.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnJa7);

        rdbtnNee7 = new JRadioButton("Nee");
        rdbtnNee7.setBounds(82, 325, 109, 23);
        rdbtnNee7.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnNee7);

        ButtonGroup group7 = new ButtonGroup();
        group7.add(rdbtnJa7);
        group7.add(rdbtnNee7);

        lblMetal = new JLabel("Heeft de auto Metalic?");
        lblMetal.setBounds(10, 351, 181, 14);
        lblMetal.setVisible(false);
        frmSimplegui.getContentPane().add(lblMetal);

        rdbtnJa8 = new JRadioButton("Ja");
        rdbtnJa8.setBounds(10, 372, 63, 23);
        rdbtnJa8.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnJa8);

        rdbtnNee8 = new JRadioButton("Nee");
        rdbtnNee8.setBounds(82, 372, 109, 23);
        rdbtnNee8.setVisible(false);
        frmSimplegui.getContentPane().add(rdbtnNee8);

        ButtonGroup group8 = new ButtonGroup();
        group8.add(rdbtnJa8);
        group8.add(rdbtnNee8);

        lblDeCategorieWaar = new JLabel("De categorie waar je auto onder valt is:");
        lblDeCategorieWaar.setBounds(227, 11, 237, 14);
        lblDeCategorieWaar.setVisible(false);
        frmSimplegui.getContentPane().add(lblDeCategorieWaar);

        lblCat = new JLabel("niks");
        lblCat.setBounds(227, 36, 90, 14);
        lblCat.setVisible(false);
        frmSimplegui.getContentPane().add(lblCat);
    }
/*

    private void makeTree(){
        tree = new ReadFile("TrainingSet.txt").getDecisionTree();
    }
*/

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
                else if(answerString1 == "0" && answerString2 == "1")
                    answer4 = "Middle";
                else if(answerString1 == "0" && answerString2 == "0")
                    answer4 = "Low";

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