package Shape;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	
	protected int x1;
	protected int y1;
	
	public Shape() {
		
	}
	
	public abstract void draw(Graphics g);
	
	public boolean isInside(Point p) {
		return false;
	}
	
	public void reLocate(int moveX, int moveY) {
		
	}

	public void showPort(Graphics g) {
		
	}

	public Port getClosetPort(int x, int y) {
		return null;
	}
	
	public abstract Point [] getShapePoint();
	
	public boolean isGroup() {
		return false;
	}

	public void setObjectName(String objName) {
	}

}
