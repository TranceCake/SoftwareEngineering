package test;
import classifier.*;
import junit.framework.TestCase;



public class TestClassifier extends TestCase {

    public TestClassifier(String arg0) {
        super(arg0);
    }

    private DecisionTree buildTree(){
        Node root = new Node("AC");

        Node n1=new Node("ABS");
        Node n2=new Node("ABS");

        Node n3=new Node("Airbag");
        Node n4=new Node("Airbag");
        Node n5=new Node("Airbag");
        Node n6=new Node("Airbag");


        root.addChild("yes",n1);
        root.addChild("no",n2);

        // leaves
        Node l1 = new Node("high");
        Node l2 = new Node("medium");
        Node l3 = new Node("low");

        // AC yes
        n1.addChild("yes",n3);
        n1.addChild("no",n4);

        // AC no
        n2.addChild("yes",n5);
        n2.addChild("no",n6);

        // AC yes, ABS yes
        n2.addChild("yes",l1);
        n2.addChild("no",l2);

        // AC yes ABS no
        n4.addChild("yes", l2);
        n4.addChild("no", l2);

        // AC no ABS yes
        n5.addChild("yes", l2);
        n5.addChild("no", l2);

        // AC no ABS no
        n6.addChild("yes", l2);
        n6.addChild("no", l3);

        return new DecisionTree(root);
    }
    public void testCategory(){

        DecisionTree dt = buildTree();

        FeatureType yn = new FeatureType("YesNo"
                ,new String[]{"yes","no"});

        Feature[] features = new Feature[]
                { new Feature("AC","yes",yn),
                        new Feature("ABS","yes",yn),
                        new Feature("Airbag", "yes", yn)
                };

        Item item = new Item("car",features);

        String category = dt.assignCategory(item);
        assertEquals("Airbag",category);


        item.setFeatureValue("AC","no");
        category = dt.assignCategory(item);
        assertEquals("high",category);

        item.setFeatureValue("ABS","no");
        category = dt.assignCategory(item);
        assertEquals("medium",category);

        item.setFeatureValue("Airbag","no");
        category = dt.assignCategory(item);
        assertEquals("medium",category);
    }
}
