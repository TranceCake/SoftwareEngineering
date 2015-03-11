package classifier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MakeTreeFromFile {
	int[] catGroup;
	
	String result;
	String categorie;
	
	BufferedReader resultReader;
	BufferedReader categorieReader;
	
	private ArrayList<Node> optionList = new ArrayList<Node>();
	
	DecisionTree decTree;
	/**
	 * 
	 * @param result this is the file path to the options
	 * @param categorie this is the file path to the categories
	 * @param catGroup This is in order from left to right, the number of times you want the category after another. When this is empty or not enough a random amount will be generated.
	 */
	public MakeTreeFromFile(String result, String categorie, int[] catGroup){
		this.result=result;
		this.categorie=categorie;	
		this.catGroup=catGroup;
		if (!checkCatGroup(catGroup, categorie, result)){
			this.catGroup=makeRandomCatGroup(categorie, result);
		}
		readFile();
		createTree();
	}
	
	private int[] makeRandomCatGroup(String categorie, String result) {
		int lines = getAmountLines(categorie);
		int lines2 = getAmountLines(result);
		long totalAmount = (long) Math.pow(2,lines2);
		long totaal =0;
		Random rand = new Random();
		int[] catGroup= new int[lines];
		for (int i = 0; i < catGroup.length; i++) {
			if (i!=catGroup.length && totalAmount>1){
				catGroup[i] = rand.nextInt((int) (totalAmount-totaal+ 1));
				totaal+=catGroup[i];
			}
			else{
				catGroup[i]=(int) (totalAmount-totaal);
			}
		}
		return catGroup;
	}
	
	@SuppressWarnings("finally")
	private int getAmountLines(String categorie){
		int lines=0;
		BufferedReader test=null;
		try{
			test = new BufferedReader(new FileReader(categorie));
			while (test.readLine() != null) lines++;
		}
		catch(FileNotFoundException e){
			e.getStackTrace();
		}
		finally{
			try {
				test.close();
			} catch (IOException e) {}
			finally{
				return lines;
			}
		}
	}
	
	private boolean checkCatGroup(int[] catGroup, String categorie, String result){
		int lines = getAmountLines(categorie);
		int lines2 = getAmountLines(result);
		long totalAmount = (long) Math.pow(2,lines2);
		long totaalCatGroup=0;
		if (catGroup.length!=lines){
			// not enough lines
			return false;
		}
		for (int i = 0; i < catGroup.length; i++) {
			totaalCatGroup+=catGroup[i];
		}		
		if (totaalCatGroup!=totalAmount){
			// the sum is no the same as it should be
			return false;
		}		
		return true;
	}
	
	private void readFile(){
		try {
			resultReader = new BufferedReader(new FileReader(result));
			categorieReader = new BufferedReader(new FileReader(categorie));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Unable to find the file");
		}
	}
	
	private void createTree(){
		Node iroot = null;
		try{
	        String line = resultReader.readLine();
	        int lineNumber = 1;
	        Node root = new Node(line);
	        optionList.add(root);
	        line = resultReader.readLine();
	        while(line != null){
	        	for(int i=0;i<(Math.pow(2,lineNumber));i++){
	            	Node node =new Node(line);
	            	optionList.add(node);
	            }
	            line = resultReader.readLine();
	            lineNumber ++;
	        }
	            
	        int group = 0;
	        String catLine = categorieReader.readLine();
	        while(catLine != null){
	            makeCat(catLine, catGroup[group]);
	            group ++;
	            catLine = categorieReader.readLine();
	        }
	            //(2*n)+1
	        // add the node's and the leafs
	        for (int i=0; i<Math.pow(2,lineNumber)-1;i++){
	            Node node = optionList.get(i);
	            node.addChild("yes",optionList.get((2*i)+1));
	            node.addChild("no",optionList.get((2*i)+2));
			}
	        iroot = root;
        }
        catch(IOException e) {
        	e.getStackTrace();
            System.out.println("Error encountered reading the file");            
        }
		decTree = new DecisionTree(iroot);
	}
	
	private void makeCat(String cat, int aantal)
	{
		for (int i=0; i<aantal;i++){
			Node node =new Node(cat);
    		optionList.add(node);
		}
	}
	
	public DecisionTree getTree(){
		return decTree;
	}
}
