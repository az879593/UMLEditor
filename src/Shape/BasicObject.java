package Shape;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class BasicObject extends Shape {
	
	protected int WIDTH;
	protected int HEIGHT;
	protected int portSize;
	protected String objectName;
	
	protected Port[] port = new Port[4];
	
	public BasicObject () {
		
	}

	@Override
	public void draw(Graphics g) {
	}
	
	public void reLocate(int moveX, int moveY) {
		this.x1 += moveX; 
		this.y1 += moveY; 
		for(Port p : port) {
			p.reLocate(moveX, moveY);
		}
	}
	
	public void showPort(Graphics g) {
		for(Port p : port) {
			p.draw(g);
		}
	}
	
	public void initPort() {
		portSize = new Port().getSize();
		port[0] = new Port(x1, y1 - HEIGHT / 2 - portSize / 2); // top
		port[1] = new Port(x1 + WIDTH / 2 + portSize / 2, y1); // right
		port[2] = new Port(x1, y1 + HEIGHT / 2 + portSize / 2);	// bottom
		port[3] = new Port(x1 - WIDTH / 2 - portSize / 2, y1); // left
	}
	
	public Port getClosetPort(int x, int y) {
		Port closetPort = port[0];
		double closetDisance = getDistance(this.port[0].x1, this.port[0].y1, x, y);
		for(int i = 1; i < 4; i++) {
			if(closetDisance > getDistance(this.port[i].x1, this.port[i].y1, x, y)) {
				closetDisance = getDistance(this.port[i].x1, this.port[i].y1, x, y);
				closetPort = port[i];
			}
		}
		return closetPort;	
	}
	
	public double getDistance(int x1, int y1, int x2, int y2) { 
		return Math.sqrt(Math.pow(x1 - x2, 2) +  Math.pow(y1 - y2, 2));
	}
	
	public Point[] getShapePoint() {
		
		Point [] result = new Point[2];
		result[0] = new Point();
		result[1] = new Point();
		result[0].x = x1 - WIDTH / 2;
		result[0].y = y1 - HEIGHT / 2;
		result[1].x = x1 - WIDTH / 2 + WIDTH;
		result[1].y = y1 - HEIGHT / 2 + HEIGHT;
		return result;
	}
	
	public void paintObjectName(Graphics g, Rectangle rect) {
		FontMetrics metrics = g.getFontMetrics();
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(objectName)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
		
		g.drawString(objectName, x, y);
	}
	
	public void setObjectName(String s) {
		this.objectName = s;
	}
	
	public abstract void paintObject(Graphics g);

}
