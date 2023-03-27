package Shape;
import java.awt.Graphics;
import java.awt.Point;

public abstract class BasicLine extends Shape {
	
	protected Port fromPort, toPort;
	protected int arrowWidth = 18;
	protected int arrowHeight = 24;
	
	public BasicLine(Port fromP, Port toP) {
		this.fromPort = fromP;
		this.toPort = toP;
	}
	
	public void draw(Graphics g) {
		paintLine(g);
		paintArrow(g);
	}
	
	public void reLocate(int moveX, int moveY) {
		
	}
	
	public void paintLine(Graphics g) {
		Point relayPoint = getRelayPoint();
		g.drawLine(fromPort.x1, fromPort.y1, relayPoint.x, relayPoint.y);
	}
	
	public abstract void paintArrow(Graphics g);
	
	public Point getRelayPoint() {
		Point result = new Point();
		
		double x1 = fromPort.x1, y1 = fromPort.y1,
			x2 = toPort.x1, y2 = toPort.y1;
			
		double dx = x2 - x1;
		double dy = y2 - y1;
			 
		double m = Math.sqrt(Math.pow(arrowHeight, 2) / (Math.pow(dx, 2) + Math.pow(dy, 2)));
		x2 -= m * dx;
		y2 -= m * dy;
		result.x = (int) x2;
		result.y = (int) y2;
		return result;
	}
	
	public Point [] getTrianglePoint(Point relay, Point end) {
		
		Point [] result = new Point[2];
		result[0] = new Point();
		result[1] = new Point();
		
		double x1 = fromPort.x1, y1 = fromPort.y1,
				x2 = toPort.x1, y2 = toPort.y1;
				
		double dx = x2 - x1;
		double dy = y2 - y1;
		
		double m = Math.sqrt(Math.pow(arrowWidth, 2) / (Math.pow(dx, 2) + Math.pow(dy, 2)));
		x1 = relay.x + m * dy;
		y1 = relay.y - m * dx;
		x2 = relay.x - m * dy;
		y2 = relay.y + m * dx;

		result[0].x = (int) x1;
		result[0].y = (int) y1;
		result[1].x = (int) x2;
		result[1].y = (int) y2;
		
		return result;
	}
	
	public Point [] getShapePoint() {
		Point [] result = new Point[2];
		result[0] = new Point();
		result[1] = new Point();
		result[0].x = fromPort.x1;
		result[0].y = fromPort.y1;
		result[1].x = toPort.x1;
		result[1].y = toPort.y1;
		return result;
	}
	
	public void test() {
		System.out.println("dad");
	}
}
