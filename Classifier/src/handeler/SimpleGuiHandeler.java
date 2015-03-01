package handeler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.ScrollableTree;
import gui.DrawTreeGui;
import gui.SimpleGui;
import classifier.DecisionTree;
import classifier.Feature;
import classifier.FeatureType;
import classifier.Item;

public class SimpleGuiHandeler {
    private SimpleGui sGui;
    private DecisionTree dt;

    private Item item;

    public SimpleGuiHandeler(SimpleGui sGui, DecisionTree dt) {
        this.sGui=sGui;
        this.dt=dt;
        FeatureType yn = new FeatureType("YesNo"
                ,new String[]{"yes","no"});

        Feature[] features = new Feature[]
                { new Feature("Turbo","yes",yn),
                        new Feature("EnginPower","yes",yn),
                        new Feature("SportBumper","yes",yn),
                        new Feature("SportRing","yes",yn),
                        new Feature("CruisControll","yes",yn),
                        new Feature("ABS","yes",yn),
                        new Feature("AC","yes",yn),
                        new Feature("Metalic","yes",yn)
                };

        item = new Item("car",features);
        addHandeler();
    }

    private void addHandeler(){
        sGui.getRdJa1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("Turbo","yes");
                showQuestion2();
                changeCategorie();
            }
        });

        sGui.getRdNee1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("Turbo","no");
                showQuestion2();
                changeCategorie();
            }
        });

        sGui.getRdJa2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("EnginPower","yes");
                showQuestion3();
                changeCategorie();
            }
        });

        sGui.getRdNee2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("EnginPower","no");
                showQuestion3();
                changeCategorie();
            }
        });

        sGui.getRdJa3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("SportBumper","yes");
                showQuestion4();
                changeCategorie();
            }
        });

        sGui.getRdNee3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("SportBumper","no");
                showQuestion4();
                changeCategorie();
            }
        });

        sGui.getRdJa4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("SportRing","yes");
                showQuestion5();
                changeCategorie();
            }
        });

        sGui.getRdNee4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("SportRing","no");
                showQuestion5();
                changeCategorie();
            }
        });

        sGui.getRdJa5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("CruisControll","yes");
                showQuestion6();
                changeCategorie();
            }
        });

        sGui.getRdNee5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("CruisControll","no");
                showQuestion6();
                changeCategorie();
            }
        });

        sGui.getRdJa6().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("ABS","yes");
                showQuestion7();
                changeCategorie();
            }
        });

        sGui.getRdNee6().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("ABS","no");
                showQuestion7();
                changeCategorie();
            }
        });

        sGui.getRdJa7().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("AC","yes");
                showQuestion8();
                changeCategorie();
            }
        });

        sGui.getRdNee7().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("AC","no");
                showQuestion8();
                changeCategorie();
            }
        });

        sGui.getRdJa8().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                item.setFeatureValue("Metalic","yes");
                changeCategorie();

            }
        });

        sGui.getRdNee8().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setFeatureValue("Metalic","no");
                changeCategorie();
            }
        });

        sGui.ShowGraph().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowGraph();
            }
        });
    }

    private boolean checkAllVisable(){
        if (sGui.getLblEngin().isVisible()){
            if (sGui.getLblSportBum().isVisible()){
                if (sGui.getLblSportR().isVisible()){
                    if (sGui.getLblCruis().isVisible()){
                        if (sGui.getLblABS().isVisible()){
                            if (sGui.getLblAC().isVisible()){
                                if (sGui.getLblMetal().isVisible() && (sGui.getRdJa8().isSelected() || sGui.getRdNee8().isSelected())){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void showQuestion2(){
        sGui.getLblEngin().setVisible(true);
        sGui.getRdJa2().setVisible(true);
        sGui.getRdNee2().setVisible(true);
    }

    private void showQuestion3(){
        sGui.getLblSportBum().setVisible(true);
        sGui.getRdJa3().setVisible(true);
        sGui.getRdNee3().setVisible(true);
    }

    private void showQuestion4(){
        sGui.getLblSportR().setVisible(true);
        sGui.getRdJa4().setVisible(true);
        sGui.getRdNee4().setVisible(true);
    }

    private void showQuestion5(){
        sGui.getLblCruis().setVisible(true);
        sGui.getRdJa5().setVisible(true);
        sGui.getRdNee5().setVisible(true);
    }

    private void showQuestion6(){
        sGui.getLblABS().setVisible(true);
        sGui.getRdJa6().setVisible(true);
        sGui.getRdNee6().setVisible(true);
    }

    private void showQuestion7(){
        sGui.getLblAC().setVisible(true);
        sGui.getRdJa7().setVisible(true);
        sGui.getRdNee7().setVisible(true);
    }

    private void showQuestion8(){
        sGui.getLblMetal().setVisible(true);
        sGui.getRdJa8().setVisible(true);
        sGui.getRdNee8().setVisible(true);
    }

    private void showConclusion(){
        sGui.getLblCategorieWa().setVisible(true);
        sGui.getLblCat().setVisible(true);
    }

    private void changeCategorie(){
        if (checkAllVisable()){
            sGui.getLblCat().setText(dt.assignCategory(item));
            showConclusion();
            ShowGraphButton();
        }
    }

    private void ShowGraphButton(){
        sGui.ShowGraph().setVisible(true);
    }



    private void ShowGraph(){

        String result = "C://Users//Tanja//Documents//Jaar 2//Periode 3 software engineering//leertaak2Classifier//src//test//OptiesText.txt";
        String categorie = "C://Users//Tanja//Documents//Jaar 2//Periode 3 software engineering//leertaak2Classifier//src//test//CatText.txt";
        int[] catGroup = new int[]{30,24,30,24,20,10,68,30,20};

        DrawTreeGui drawGui = new DrawTreeGui();
        new DrawTreeHandeler(drawGui, dt);

        drawGui.getFrame().setVisible(true);
        drawGui.getFrame().setTitle("Tree with features");
        drawGui.getFrame().setBounds(200, 200, 500, 505);

        ScrollableTree treeScroll = new ScrollableTree();
        treeScroll.getFrame().setVisible(true);
        treeScroll.getFrame().setTitle("Scrollable Tree");
        treeScroll.getFrame().setBounds(700, 200, 500, 505);
        treeScroll.drawTree(dt.toString());
        treeScroll.getFrame().repaint();
    }
}
