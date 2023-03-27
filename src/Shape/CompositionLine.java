package Shape;

import java.awt.Graphics;
import java.awt.Point;

public class CompositionLine extends BasicLine {
	
	public CompositionLine(Port fromP, Port toP) {
		super(fromP, toP);
		arrowWidth = 12;
		arrowHeight = 36;
	}

	@Override
	public void paintArrow(Graphics g) {
		// TODO Auto-generated method stub
		Point relayPoint = getRelayPoint();
		// TODO Auto-generated method stub
		Point portPoint = new Point();
		portPoint.x = toPort.x1; 
		portPoint.y = toPort.y1;
		Point [] triangle = getTrianglePoint(relayPoint, portPoint);
		Point [] triangleReverse = getTrianglePoint(portPoint, relayPoint);
		
		for(int i = 0; i < 2; i++) {
			triangle[i].x = (triangle[i].x + triangleReverse[i].x) / 2;
			triangle[i].y = (triangle[i].y + triangleReverse[i].y) / 2;
		}
		
		int x[] = {triangle[0].x, toPort.x1, triangle[1].x, relayPoint.x};
		int y[] = {triangle[0].y, toPort.y1, triangle[1].y, relayPoint.y};
		
		g.fillPolygon(x, y, 4);
	}
}
