package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Group extends BasicObject {
	
	private ArrayList <Shape> shapeGroup = new ArrayList <Shape>();
	
	public Group(Rectangle r, ArrayList <Shape> shapeList) {
		shapeGroup = shapeList;
		this.x1 = r.x + r.width / 2;
		this.y1 = r.y + r.height / 2;
		this.WIDTH = r.width;
		this.HEIGHT = r.height;
	}

	public void draw(Graphics g) {
		paintObject(g);
	}
	
	public boolean isInside(Point p) {

		Rectangle r = new Rectangle(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);

		return r.contains(p);
	} 
	
	public void showPort(Graphics g) {
		for(int i = 0; i < shapeGroup.size(); i++) {
			shapeGroup.get(i).showPort(g);
			shapeGroup.get(i).draw(g);
		}
	}
	
	public void reLocate(int moveX, int moveY) {
		
		for(int i = 0; i < shapeGroup.size(); i++) {
			shapeGroup.get(i).reLocate(moveX, moveY);
		}
		this.x1 += moveX; 
		this.y1 += moveY; 
	}
	
	public ArrayList <Shape> getGroupShapes(){
		return shapeGroup;
	}
	
	public boolean isGroup() {
		return true;
	}

	public void paintObject(Graphics g) {
//		rgb(201, 238, 255) bonds color
//		rgb(47, 88, 205) rectangle color
		g.setColor(new Color(201, 238, 255, 128));
		g.fillRect(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
		g.setColor(new Color(47, 88, 205, 255));
		g.drawRect(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
		for(int i = 0; i < shapeGroup.size(); i++) {
			shapeGroup.get(i).draw(g);
		}
	}

}
