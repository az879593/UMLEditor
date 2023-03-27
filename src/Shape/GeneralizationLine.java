package Shape;

import java.awt.Graphics;
import java.awt.Point;

public class GeneralizationLine extends BasicLine {

	public GeneralizationLine(Port fromP, Port toP) {
		super(fromP, toP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintArrow(Graphics g) {
		// TODO Auto-generated method stub
		Point portPoint = new Point();
		portPoint.x = toPort.x1; 
		portPoint.y = toPort.y1;
		Point [] triangle = getTrianglePoint(getRelayPoint(), portPoint);
		
		int x[] = {triangle[0].x, triangle[1].x, toPort.x1};
		int y[] = {triangle[0].y, triangle[1].y, toPort.y1};
		
		g.drawPolygon(x, y, 3);
	}

}
