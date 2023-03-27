package Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class UseCase extends BasicObject {
	
	public UseCase () {
		
	}
	
	public UseCase (int x1, int y1) {
		WIDTH = 150;
		HEIGHT = 100;
		this.x1 = x1;
		this.y1 = y1;
		initPort();
		objectName = "UseCase";
	}
	
	public void draw(Graphics g) {
		paintObject(g);
		paintObjectName(g, new Rectangle(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT));
	}
	
	public boolean isInside(Point p) {
		Rectangle r = new Rectangle(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
		return r.contains(p);
	}
	
	public void paintObject(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawOval(x1 - WIDTH / 2, y1 - HEIGHT / 2, WIDTH, HEIGHT);
	}
}
