package gui;

import classifier.DecisionTree;
import classifier.MakeTreeFromFile;
import handeler.SimpleGuiHandeler;

import javax.swing.*;
import java.awt.*;

public class SimpleGui {

	private JFrame frmSimplegui;
	
	private JRadioButton rdbtnNee1;
	private JRadioButton rdbtnNee2;
	private JRadioButton rdbtnNee3;
	private JRadioButton rdbtnNee4;
	private JRadioButton rdbtnNee5;
	private JRadioButton rdbtnNee6;
	private JRadioButton rdbtnNee7;
	private JRadioButton rdbtnNee8;
	
	private JRadioButton rdbtnJa1;
	private JRadioButton rdbtnJa2;
	private JRadioButton rdbtnJa3;
	private JRadioButton rdbtnJa4;
	private JRadioButton rdbtnJa5;
	private JRadioButton rdbtnJa6;
	private JRadioButton rdbtnJa7;
	private JRadioButton rdbtnJa8;
    private JButton rdbtnTree;
	
	private JLabel lblTurbo;
	private JLabel lblEngin;
	private JLabel lblSportBum;
	private JLabel lblSportR;
	private JLabel lblCruis;
	private JLabel lblABS;
	private JLabel lblAC;
	private JLabel lblMetal;
	
	private JLabel lblDeCategorieWaar;
	private JLabel lblCat;

    private JButton showGraph;

	/**
	 * Create the application.
	 */
	public SimpleGui() {
		initialize();
	}
	
	public JFrame getFrame(){
		return frmSimplegui;
	}
	
	public JRadioButton getRdJa1(){
		return rdbtnJa1;
	}
	
	public JRadioButton getRdJa2(){
		return rdbtnJa2;
	}
	
	public JRadioButton getRdJa3(){
		return rdbtnJa3;
	}
	
	public JRadioButton getRdJa4(){
		return rdbtnJa4;
	}
	
	public JRadioButton getRdJa5(){
		return rdbtnJa5;
	}
	
	public JRadioButton getRdJa6(){
		return rdbtnJa6;
	}
	
	public JRadioButton getRdJa7(){
		return rdbtnJa7;
	}
	
	public JRadioButton getRdJa8(){
		return rdbtnJa8;
	}

	public JRadioButton getRdNee1(){
		return rdbtnNee1;
	}
	
	public JRadioButton getRdNee2(){
		return rdbtnNee2;
	}

	public JRadioButton getRdNee3(){
		return rdbtnNee3;
	}
	
	public JRadioButton getRdNee4(){
		return rdbtnNee4;
	}
	
	public JRadioButton getRdNee5(){
		return rdbtnNee5;
	}
	
	public JRadioButton getRdNee6(){
		return rdbtnNee6;
	}
	
	public JRadioButton getRdNee7(){
		return rdbtnNee7;
	}

	public JRadioButton getRdNee8(){
		return rdbtnNee8;
	}
	
	public JLabel getLblTurbo(){
		return lblTurbo;
	}
	
	public JLabel getLblEngin(){
		return lblEngin;
	}
	
	public JLabel getLblSportBum(){
		return lblSportBum;
	}
	
	public JLabel getLblSportR(){
		return lblSportR;
	}
	
	public JLabel getLblCruis(){
		return lblCruis;
	}
	
	public JLabel getLblABS(){
		return lblABS;
	}
	
	public JLabel getLblAC(){
		return lblAC;
	}
	
	public JLabel getLblMetal(){
		return lblMetal;
	}
	
	public JLabel getLblCategorieWa(){
		return lblDeCategorieWaar;
	}
	
	public JLabel getLblCat(){
		return lblCat;
	}

    public JButton ShowGraph(){
        return showGraph;
    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimplegui = new JFrame();
		frmSimplegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimplegui.getContentPane().setLayout(null);
		
		lblTurbo = new JLabel("Does the car have Turbo?");
		lblTurbo.setBounds(10, 11, 200, 14);
		frmSimplegui.getContentPane().add(lblTurbo);
		
		rdbtnJa1 = new JRadioButton("Yes");
		rdbtnJa1.setBounds(6, 32, 63, 23);
		frmSimplegui.getContentPane().add(rdbtnJa1);
		
		rdbtnNee1 = new JRadioButton("No");
		rdbtnNee1.setBounds(82, 32, 109, 23);
		frmSimplegui.getContentPane().add(rdbtnNee1);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rdbtnJa1);
		group1.add(rdbtnNee1);
		 
		lblEngin = new JLabel("Does the car have EnginePower?");
		lblEngin.setBounds(10, 69, 200, 14);
		lblEngin.setVisible(false);
		frmSimplegui.getContentPane().add(lblEngin);
		
		rdbtnJa2 = new JRadioButton("Yes");
		rdbtnJa2.setBounds(10, 90, 63, 23);
		rdbtnJa2.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnJa2);
		
		rdbtnNee2 = new JRadioButton("No");
		rdbtnNee2.setBounds(82, 90, 109, 23);
		rdbtnNee2.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnNee2);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnJa2);
		group2.add(rdbtnNee2);
		
		lblSportBum = new JLabel("Does the car have a SportsBumper?");
		lblSportBum.setBounds(14, 116, 200, 14);
		lblSportBum.setVisible(false);
		frmSimplegui.getContentPane().add(lblSportBum);
		
		rdbtnJa3 = new JRadioButton("Yes");
		rdbtnJa3.setBounds(10, 137, 63, 23);
		rdbtnJa3.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnJa3);
		
		rdbtnNee3 = new JRadioButton("No");
		rdbtnNee3.setBounds(82, 137, 109, 23);
		rdbtnNee3.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnNee3);
		
		ButtonGroup group3 = new ButtonGroup();
		group3.add(rdbtnJa3);
		group3.add(rdbtnNee3);
		
		lblSportR = new JLabel("Does the car have a SportsRing?");
		lblSportR.setBounds(10, 163, 200, 14);
		lblSportR.setVisible(false);
		frmSimplegui.getContentPane().add(lblSportR);
		
		rdbtnJa4 = new JRadioButton("Yes");
		rdbtnJa4.setBounds(10, 184, 63, 23);
		rdbtnJa4.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnJa4);
		
		rdbtnNee4 = new JRadioButton("No");
		rdbtnNee4.setBounds(82, 184, 109, 23);
		rdbtnNee4.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnNee4);
		
		ButtonGroup group4 = new ButtonGroup();
		group4.add(rdbtnJa4);
		group4.add(rdbtnNee4);
		
		lblCruis = new JLabel("Does the car have CruisControll?");
		lblCruis.setBounds(14, 210, 200, 14);
		lblCruis.setVisible(false);
		frmSimplegui.getContentPane().add(lblCruis);
		
		rdbtnJa5 = new JRadioButton("Yes");
		rdbtnJa5.setBounds(10, 231, 63, 23);
		rdbtnJa5.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnJa5);
		
		rdbtnNee5 = new JRadioButton("No");
		rdbtnNee5.setBounds(82, 231, 109, 23);
		rdbtnNee5.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnNee5);
		
		ButtonGroup group5 = new ButtonGroup();
		group5.add(rdbtnJa5);
		group5.add(rdbtnNee5);
		
		lblABS = new JLabel("Does the car have ABS?");
		lblABS.setBounds(10, 257, 200, 14);
		lblABS.setVisible(false);
		frmSimplegui.getContentPane().add(lblABS);
		
		rdbtnJa6 = new JRadioButton("Yes");
		rdbtnJa6.setBounds(10, 278, 63, 23);
		rdbtnJa6.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnJa6);
		
		rdbtnNee6 = new JRadioButton("No");
		rdbtnNee6.setBounds(82, 278, 109, 23);
		rdbtnNee6.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnNee6);
		
		ButtonGroup group6 = new ButtonGroup();
		group6.add(rdbtnJa6);
		group6.add(rdbtnNee6);
		
		lblAC = new JLabel("Does the car have AC?");
		lblAC.setBounds(10, 304, 200, 14);
		lblAC.setVisible(false);
		frmSimplegui.getContentPane().add(lblAC);
		
		rdbtnJa7 = new JRadioButton("Yes");
		rdbtnJa7.setBounds(10, 325, 63, 23);
		rdbtnJa7.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnJa7);
		
		rdbtnNee7 = new JRadioButton("No");
		rdbtnNee7.setBounds(82, 325, 109, 23);
		rdbtnNee7.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnNee7);
		
		ButtonGroup group7 = new ButtonGroup();
		group7.add(rdbtnJa7);
		group7.add(rdbtnNee7);
		
		lblMetal = new JLabel("Does the car have a Metalic skin?");
		lblMetal.setBounds(10, 351, 200, 14);
		lblMetal.setVisible(false);
		frmSimplegui.getContentPane().add(lblMetal);
		
		rdbtnJa8 = new JRadioButton("Yes");
		rdbtnJa8.setBounds(10, 372, 63, 23);
		rdbtnJa8.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnJa8);
		
		rdbtnNee8 = new JRadioButton("No");
		rdbtnNee8.setBounds(82, 372, 109, 23);
		rdbtnNee8.setVisible(false);
		frmSimplegui.getContentPane().add(rdbtnNee8);
		
		ButtonGroup group8 = new ButtonGroup();
		group8.add(rdbtnJa8);
		group8.add(rdbtnNee8);
		
		lblDeCategorieWaar = new JLabel("The category your car is under:");
		lblDeCategorieWaar.setBounds(227, 11, 237, 14);
		lblDeCategorieWaar.setVisible(false);
		frmSimplegui.getContentPane().add(lblDeCategorieWaar);

        showGraph = new JButton("Show Graph");
        showGraph.setBounds(230, 60, 110, 24);
        showGraph.setVisible(false);
        frmSimplegui.getContentPane().add(showGraph);

        ButtonGroup group9 = new ButtonGroup();
        group9.add(showGraph);
/*
        String result = "C://Users//Tanja//Documents//Jaar 2//Periode 3 software engineering//leertaak2Classifier//src//test//OptiesText.txt";
        String categorie = "C://Users//Tanja//Documents//Jaar 2//Periode 3 software engineering//leertaak2Classifier//src//test//CatText.txt";
        int[] catGroup = new int[]{30,24,30,24,20,10,68,30,20};

        DecisionTree dt = new MakeTreeFromFile(result,categorie, catGroup).getTree();
        SimpleGui sGui = new SimpleGui();
        new SimpleGuiHandeler(sGui,dt);
        ScrollableTree treeScroll = new ScrollableTree();
        treeScroll.getFrame().setVisible(true);
        treeScroll.getFrame().setTitle("Draw tree and scroll");
        treeScroll.getFrame().setBounds(100, 100, 500, 505);
        treeScroll.drawTree(dt.toString());
        treeScroll.getFrame().repaint();
		*/
		lblCat = new JLabel("Nothing");
		lblCat.setBounds(227, 36, 90, 14);
		lblCat.setVisible(false);
		frmSimplegui.getContentPane().add(lblCat);
	}
}
