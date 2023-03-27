package View;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Mode.Mode;
import Shape.Group;
import Shape.Shape;

public class Canva extends JPanel {
	
	private static Canva instance = null;
	
	private Mode currentMode = null;
	
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
	public Shape selectedObject = null;
	
	public Rectangle selectedArea = null;

	//	Singleton
	private Canva() {}
	
	public static Canva getInstance() {
		if(instance == null) {
            instance = new Canva();
        }
        return instance;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < shapeList.size(); i++) {
			shapeList.get(i).draw(g);
			if(shapeList.get(i) == selectedObject) {
				selectedObject.showPort(g);
			}
		}
		
		if(selectedArea != null) {
			g.drawRect(selectedArea.x, selectedArea.y, selectedArea.width, selectedArea.height);
		}
	}

	public ArrayList<Shape> getShapeList() {
		return shapeList;
	}

	public void addShape(Shape shape) {
		shapeList.add(shape);
	}
	
	public void setMode(Mode mode) {
		selectedObject = null;
		removeMouseListener(currentMode);
		removeMouseMotionListener(currentMode);
		currentMode = mode;
		addMouseListener(currentMode);
		addMouseMotionListener(currentMode);
	}
	
	public void setSelected(Shape s) {
		selectedObject = s;
	}
	
	public Shape getSelected() {
		return selectedObject;
	}
	
	public void testOutput() { System.out.println("test work"); }
	
	public ArrayList <Shape> getShapeByPoint(Point p){
		ArrayList <Shape> result = new ArrayList<Shape>();
		for(int i = shapeList.size() - 1; i >= 0; i--) {
			if(shapeList.get(i).isInside(p)) {
				result.add(shapeList.get(i));
			}
		}
		return result;
	}
	
	public ArrayList <Shape> getShapesByRect(Rectangle r){
		ArrayList <Shape> result = new ArrayList<Shape>();
//		for(int i = shapeList.size() - 1; i >= 0; i--) {
		for(int i = 0 ; i < shapeList.size(); i++) {
			short isInside = 0;
			for(Point p : shapeList.get(i).getShapePoint()) {
				if(r != null && r.contains(p)) {
					isInside += 1;
				}
			}
			if(isInside > 1) {
				result.add(shapeList.get(i));
			}
		}
		return result;
	}
	
	public void groupShape() {
		ArrayList<Shape> tempList = getShapesByRect(selectedArea);
		if(tempList.size() > 1) {
			addShape(new Group(selectedArea, tempList));
			for(Shape s : tempList) {
				getShapeList().remove(s);
			}
		}
		selectedArea = null;
		repaint();
	}
	
	public void unGroupShape() {
		if(getSelected() != null && getSelected().isGroup()) {
			Group temp = (Group)getSelected();
			for(Shape s : temp.getGroupShapes()) {
				getShapeList().add(s);
			}
			getShapeList().remove(temp);
		}
		selectedArea = null;
		repaint();
	}
	
	public void changeObjectName() {
		if(getSelected() != null && !getSelected().isGroup()) {
			String objName = JOptionPane.showInputDialog("§ó§ïClass¦WºÙ");
			getSelected().setObjectName(objName);
			repaint();
		}
	}
}
