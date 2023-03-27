package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Port extends Shape {
	
	private int SIZE;
	
	public Port() {
		SIZE = 10;
	}
	
	public Port(int x1, int y1) {
		SIZE = 10;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(x1 - SIZE / 2, y1 - SIZE / 2, SIZE, SIZE);
	}
	
	public void reLocate(int moveX, int moveY) {
		this.x1 += moveX; 
		this.y1 += moveY; 
	}
	
	public int getSize() {
		return SIZE;
	}
	
	public boolean isInside(Point p) {
		Rectangle r = new Rectangle(x1 - SIZE / 2, y1 - SIZE / 2, SIZE, SIZE);
		return r.contains(p);
	}
	
	public void setPoint(Point p) {
		this.x1 = p.x;
		this.y1 = p.y;
	}

	@Override
	public Point[] getShapePoint() {
		// TODO Auto-generated method stub
		return null;
	}
}
