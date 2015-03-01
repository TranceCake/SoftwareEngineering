package main;

import gui.SimpleGui;
import handeler.SimpleGuiHandeler;
import classifier.DecisionTree;
import classifier.MakeTreeFromFile;

public class Main {
    public static void main(String [] args)
    {
        String result = "C://Users//Tanja//Documents//Jaar 2//Periode 3 software engineering//leertaak2Classifier//src//test//OptiesText.txt";
        String categorie = "C://Users//Tanja//Documents//Jaar 2//Periode 3 software engineering//leertaak2Classifier//src//test//CatText.txt";
        int[] catGroup = new int[]{30,24,30,24,20,10,68,30,20};

        DecisionTree dt = new MakeTreeFromFile(result,categorie, catGroup).getTree();
        SimpleGui sGui = new SimpleGui();
        new SimpleGuiHandeler(sGui,dt);

        sGui.getFrame().setVisible(true);
        sGui.getFrame().setTitle("simpleGui");
        sGui.getFrame().setBounds(100, 100, 500, 505);

        /*DrawTreeGui drawGui = new DrawTreeGui();
        new DrawTreeHandeler(drawGui, dt);

        drawGui.getFrame().setVisible(true);
        drawGui.getFrame().setTitle("Draw Gui");
        drawGui.getFrame().setBounds(100, 100, 500, 505);

        ScrollableTree treeScroll = new ScrollableTree();
        treeScroll.getFrame().setVisible(true);
        treeScroll.getFrame().setTitle("Draw tree and scroll");
        treeScroll.getFrame().setBounds(100, 100, 500, 505);
        treeScroll.drawTree(dt.toString());
        treeScroll.getFrame().repaint();*/
    }
}
