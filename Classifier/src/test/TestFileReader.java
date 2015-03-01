package test;
import junit.framework.TestCase;
import classifier.*;

public class TestFileReader extends TestCase {
	private static final String RESULT = "C:\\Users\\Robert\\workspace\\Opdracht 10\\src\\test\\OptiesText.txt";
	private static final String CATEGORIE = "C:\\Users\\Robert\\workspace\\Opdracht 10\\src\\test\\CatText.txt";
	private static final int[] CATGROUP = new int[]{30,24,30,24,20,10,68,30,20};

	public TestFileReader(String arg0) {
		super(arg0);
	}

	public void testCategory(){
		DecisionTree dt = new MakeTreeFromFile(RESULT, CATEGORIE, CATGROUP).getTree();

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
		
		Item item = new Item("car",features);
		
		String category = dt.assignCategory(item);
		assertEquals("High",category);
		
		item.setFeatureValue("Turbo","no");
		category = dt.assignCategory(item);
		assertEquals("Medium-High",category);
		
		
		item.setFeatureValue("EnginPower","no");
		category = dt.assignCategory(item);
		assertEquals("Medium",category);
		
	}
	
}
