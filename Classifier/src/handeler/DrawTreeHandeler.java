package handeler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.DrawTreeGui;
import classifier.DecisionTree;

public class DrawTreeHandeler {
	private DrawTreeGui drawGui;
	private DecisionTree dt;
	
	public DrawTreeHandeler(DrawTreeGui drawGui, DecisionTree dt) {
		this.drawGui=drawGui;
		this.dt=dt;
		addHandelers();
	}
	
	private void addHandelers(){
		drawGui.getBtnDraw().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawGui.drawTree(dt.toString());
			}
		});
	}

}
