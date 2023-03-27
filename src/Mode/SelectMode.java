package Mode;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Shape.Shape;


public class SelectMode extends Mode {
	
	private Point prevPoint;
	
	public void mousePressed(MouseEvent e) {
	
		prevPoint = e.getPoint();
		
		if(canva.getShapeByPoint(prevPoint).size() != 0) {
			canva.setSelected(canva.getShapeByPoint(prevPoint).get(0));
		} else {
			canva.setSelected(null);
			canva.selectedArea = new Rectangle();
		}
		canva.repaint();
	}
	
	
	public void mouseDragged(MouseEvent e) {

		if(canva.getSelected() != null) {
			canva.getSelected().reLocate(e.getX() - prevPoint.x, e.getY() - prevPoint.y);
			canva.repaint();
			prevPoint.x = e.getX();
			prevPoint.y = e.getY();
		} else {
			int x1 = Math.min(prevPoint.x, e.getX());
			int y1 = Math.min(prevPoint.y, e.getY());
			canva.selectedArea.setBounds(x1, y1, Math.abs(e.getX() - prevPoint.x), Math.abs(e.getY() - prevPoint.y));
			canva.repaint();
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(canva.getSelected() == null) {
			ArrayList<Shape> tempList = canva.getShapesByRect(canva.selectedArea);
			if(tempList.size() < 2) {
				canva.selectedArea = null;
				canva.repaint();
			}
		}
	}
}
