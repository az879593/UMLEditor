package Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Class extends BasicObject {
	
	public Class () {
		
	}
	
	public Class (int x1, int y1) {
		WIDTH = 150;
		HEIGHT = 200;
		this.x1 = x1;
		this.y1 = y1;
		initPort();
		objectName = "Class";
	}
	
	public void draw(Graphics g) {
		paintObject(g);
		paintObjectName(g, new Rectangle(x1 - WIDTH / 2, y1 - 7 * HEIGHT / 8, WIDTH, HEIGHT));
	}
	
	public boolean isInside(Point p) {

		Rectangle r = new Rectangle(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
		for(int i = 0; i < 4; i++) {
			if(port[i].isInside(p)) {
				return true;
			}
		}
		return r.contains(p);
	}
	
	public void paintObject(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawRect(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
		g.drawLine(x1 - WIDTH / 2, y1 - HEIGHT / 4, x1 + WIDTH / 2, y1 - HEIGHT / 4); 
		g.drawLine(x1 - WIDTH / 2, y1, x1 + WIDTH / 2, y1);
	}

}
