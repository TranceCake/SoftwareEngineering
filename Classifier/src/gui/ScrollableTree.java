package gui;

import javax.swing.*;

import java.awt.*;
import java.util.*;
 
public class ScrollableTree {
    
    private JPanel panel;
    private JFrame frame;
    private static JPanel drawingPane;
    private static Vector<Rectangle> dataForRectangles; //coordinates used to draw the rectangles
    private static Vector<CharObject> dataForStrings; //coordinates used to draw the strings
    private static Vector<LineObject> dataForLines; //coordinates used to draw the strings

    
    public ScrollableTree() {
    	initialize();
    }
    
    private void initialize() {
    	//Create and set up the window.
        frame = new JFrame("ScrollDemo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
    	panel.setLayout(new BorderLayout());
    	dataForRectangles = new Vector<Rectangle>();
    	dataForStrings= new Vector<CharObject>();
    	dataForLines = new Vector<LineObject>();

        //Set up the drawing area.
        drawingPane = new DrawingPane();
        drawingPane.setBackground(Color.white);
        
         
        //Put the drawing area in a scroll pane.
        JScrollPane scroller = new JScrollPane(drawingPane);
        scroller.setPreferredSize(new Dimension(200,200));
 
        panel.add(scroller, BorderLayout.CENTER);
        
        //Create and set up the content pane.
        JComponent newContentPane = panel;
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
    }
    
    public JFrame getFrame(){
    	return frame;
    }
    
    public static void changeSize(int w, int h){
    	drawingPane.setPreferredSize(new Dimension(w,h));
        drawingPane.revalidate();
        drawingPane.repaint();
    }
    
    /**
     * draw the tree
     * @param tree
     */
    public void drawTree(String tree){		
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
		// get all the information out of the .toString()
		// get the amount of lines for the size
		while(check){
			String line = treeSplitted.get(counter+1);
			if (line.contains("[") && line.contains("]")){
				check =false;
			}
			else if(line.contains("[")){
				counter++;
			}
		}
		changeSize((int) Math.pow(2, counter+1)*100,(counter+1)*75);
		check=true;
		counter =0;
		
		int width = drawingPane.getPreferredSize().width;
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
					CharObject cha = new CharObject(c_arr, widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-20, 35+depthTree.get(key)*75 );
			    	dataForStrings.addElement(cha);
				}
				Rectangle rect= new Rectangle(widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-40, 40+depthTree.get(key)*75 , 80, 25);
				dataForRectangles.addElement(rect);
				char[] c_arr = line.substring(line.indexOf("[")+1,line.indexOf("]")).toCharArray();
				CharObject cha = new CharObject(c_arr, widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-35, 15+40+depthTree.get(key)*75);
		    	dataForStrings.addElement(cha);
				width = widthCountTree.get(key)+1;
				widthCountTree.put(key, width);
			}
			else if(line.contains("[")){
				String key =line.substring(line.indexOf("[")+1);
				if(line.contains("(")&&line.contains(")")){
					char[] c_arr = line.substring(line.indexOf("(")+1,line.indexOf(")")).toCharArray();
					CharObject cha = new CharObject(c_arr, widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-20, 35+depthTree.get(key)*75 );
			    	dataForStrings.addElement(cha);
				}
				Rectangle rect= new Rectangle(widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-40, 40+depthTree.get(key)*75 , 80, 25);
				dataForRectangles.addElement(rect);
				char[] c_arr = key.toCharArray();
				CharObject cha = new CharObject(c_arr, widthSizeTree.get(key)+(widthSizeTree.get(key)*2*widthCountTree.get(key))-35, 15+40+depthTree.get(key)*75);
		    	dataForStrings.addElement(cha);
				width = widthCountTree.get(key)+1;
				widthCountTree.put(key, width);
			}
		}
		// TODO line
		Iterator it = depthTree.entrySet().iterator();
		HashMap<Integer,String> depLine = new HashMap<Integer,String>();
	    while (it.hasNext()) {
	    	Map.Entry pairs = (Map.Entry)it.next();
	    	Integer temp = (Integer) pairs.getValue();
	    	String key = (String) pairs.getKey();
	    	depLine.put(temp, key);
	    }
	    
	    it = depLine.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry pairs = (Map.Entry)it.next();
	    	Integer temp = (Integer) pairs.getKey();
	    	String key = (String) pairs.getValue();
	    	LineObject line=new LineObject(0, 0, 0, 0);
	    	int count=0;
	    	for (int i = 0; i < Math.pow(2, (double) temp); i++) {
	    		if (depLine.containsKey(temp+1)){
		    		int x1 = widthSizeTree.get(key)+(widthSizeTree.get(key)*2*i);
		    		int y1 = 40+depthTree.get(key)*75+25;
		    		int x2 = widthSizeTree.get(depLine.get(temp+1))+(count*widthSizeTree.get(depLine.get(temp)));
		    		int y2 = 40+depthTree.get(depLine.get(temp+1))*75;
					line = new LineObject(x1, y1, x2, y2);
					dataForLines.addElement(line);
					count ++;
					x1 = widthSizeTree.get(key)+(widthSizeTree.get(key)*2*i);
		    		y1 = 40+depthTree.get(key)*75+25;
		    		x2 = widthSizeTree.get(depLine.get(temp+1))+(count*widthSizeTree.get(depLine.get(temp)));
		    		y2 = 40+depthTree.get(depLine.get(temp+1))*75;
					line = new LineObject(x1, y1, x2, y2);
					dataForLines.addElement(line);
					count ++;
	    		}
	    	}
	    }
		drawingPane.scrollRectToVisible(dataForRectangles.elementAt(0));
	}
    
    
    /** The component inside the scroll pane. */
    public class DrawingPane extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
            super.paintComponent(g);
 
            // draw all the rectangles
            Rectangle rect;
            for (int i = 0; i < dataForRectangles.size(); i++) {
                rect = dataForRectangles.elementAt(i);
                g.drawRect(rect.x, rect.y, rect.width, rect.height);
            }
            
            // draw all the strings
            CharObject string;
            for (int i = 0; i<dataForStrings.size(); i++){
            	string = dataForStrings.elementAt(i);
            	g.drawChars(string.getC(), 0, string.getC().length, string.getX(), string.getY());
            }
            
            // draw all the lines
            LineObject line;
            for (int i = 0; i<dataForLines.size(); i++){
            	line = dataForLines.elementAt(i);
            	g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            }
        }
    }
    
    
    /**
     * the component CharObject for the strings that are drawn
     * @author Robert
     *
     */
    public class CharObject{
    	char[] c;
    	int x;
    	int y;
    	public CharObject(char[] c,int x, int y){
	    	this.c=c;
	    	this.x=x;
	    	this.y=y;
    	}
    	
    	public char[] getC(){
    		return c;
    	}
    	
    	public int getX(){
    		return x;
    	}
    	
    	public int getY(){
    		return y;
    	}
    }

    public class LineObject{
    	int x1;
    	int y1;
    	int x2;
    	int y2;
    	
    	public LineObject(int x1, int y1, int x2, int y2){
    		this.x1=x1;
    		this.y1=y1;
    		this.x2=x2;
    		this.y2=y2;
    	}
    	
    	public int getX1(){
    		return x1;
    	}
    	
    	public int getY1(){
    		return y1;
    	}

    	public int getX2(){
    		return x2;
    	}
    	
    	public int getY2(){
    		return y2;
    	}
    	
    	public void setX2(int x2){
    		this.x2=x2;
    	}
    	
    	public void setY2(int y2){
    		this.y2=y2;
    	}
    	
    }
}