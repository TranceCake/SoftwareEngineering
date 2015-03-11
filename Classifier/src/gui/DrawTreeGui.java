package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JButton;


public class DrawTreeGui {

	private JFrame frame;
	private JButton btnDrawTree;
	private Graphics g;

	/**
	 * Create the application.
	 */
	public DrawTreeGui() {
		initialize();
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public JButton getBtnDraw(){
		return btnDrawTree;
	}
	
	public void drawTree(String tree){
		g = frame.getGraphics();
		
		ArrayList<String> treeSplitted = new ArrayList<String>();
		Scanner scanner = new Scanner(tree);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  treeSplitted.add(line);
		}
		scanner.close();
		
		boolean check=true;
		int counter =0;
		HashMap<String, Integer> depthTree = new HashMap<String,Integer>();
		HashMap<String, Integer> widthSizeTree = new HashMap<String,Integer>();
		HashMap<String, Integer> widthCountTree = new HashMap<String,Integer>();
		int width = frame.getSize().width;
		// get all the information out of the .toString()
        //System.out.println(tree.toString());
		while(check){
			String line = treeSplitted.get(counter+1);
			if (line.contains("[") && line.contains("]")){
				widthSizeTree.put("categorie",(int) Math.ceil(width/Math.pow(2, counter+1)));
				widthCountTree.put("categorie",0);
				depthTree.put("categorie", counter);
				check =false;
			}
			else if(line.contains("[")){
				widthSizeTree.put(line.substring(line.indexOf("[")+1),(int) Math.ceil(width/Math.pow(2, counter+1)));
				widthCountTree.put(line.substring(line.indexOf("[")+1),0);
				depthTree.put(line.substring(line.indexOf("[")+1),counter);
				counter++;
			}
		}
		// draw the boxes on the screen
		Iterator<String> iterator = treeSplitted.iterator();
		while (iterator.hasNext()) {
			String line = iterator.next();
			if (line.contains("[")&& line.contains("]")){
				String key = "categorie";
				if(line.contains("(")&&line.contains(")")){
					char[] c_arr = line.substring(line.indexOf("(")+1,line.indexOf(")")).toCharArray();
					g.drawChars(c_arr, 0, c_arr.length, widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-20, 35+depthTree.get(key)*75 );
				}
				g.drawRect(widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-40, 40+depthTree.get(key)*75 , 80, 25);
				char[] c_arr = line.substring(line.indexOf("[")+1,line.indexOf("]")).toCharArray();
				g.drawChars(c_arr, 0, c_arr.length, widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-35, 15+40+depthTree.get(key)*75);
				width = widthCountTree.get(key)+1;
				widthCountTree.put(key, width);
			}
			else if(line.contains("[")){
				String key =line.substring(line.indexOf("[")+1);
				if(line.contains("(")&&line.contains(")")){
					char[] c_arr = line.substring(line.indexOf("(")+1,line.indexOf(")")).toCharArray();
					g.drawChars(c_arr, 0, c_arr.length, widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-20, 35+depthTree.get(key)*75 );
				}
				g.drawRect(widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-40, 40+depthTree.get(key)*75 , 80, 25);
				char[] c_arr = key.toCharArray();
				g.drawChars(c_arr, 0, key.length(), widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-35, 15+40+depthTree.get(key)*75);
				width = widthCountTree.get(key)+1;
				widthCountTree.put(key, width);
			} 
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnDrawTree = new JButton("Draw tree");
		btnDrawTree.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnDrawTree);
	}
}
