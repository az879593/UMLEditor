package Shape;

import java.awt.Graphics;
import java.awt.Point;

public class AssociationLine extends BasicLine {

	public AssociationLine(Port fromP, Port toP) {
		super(fromP, toP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintArrow(Graphics g) {
		Point relayPoint = getRelayPoint();
		// TODO Auto-generated method stub
		Point portPoint = new Point();
		portPoint.x = toPort.x1; 
		portPoint.y = toPort.y1;
		Point [] triangle = getTrianglePoint(relayPoint, portPoint);
		
		g.drawLine(triangle[0].x, triangle[0].y, toPort.x1, toPort.y1);
		g.drawLine(triangle[1].x, triangle[1].y, toPort.x1, toPort.y1);
		g.drawLine(relayPoint.x, relayPoint.y, toPort.x1, toPort.y1);
	}
}
