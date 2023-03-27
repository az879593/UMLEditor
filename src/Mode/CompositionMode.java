package Mode;

import java.awt.event.MouseEvent;

import Shape.CompositionLine;
import Shape.Port;

public class CompositionMode extends LineMode {
	
	public void mousePressed(MouseEvent e) {
		getFromPort(e.getPoint());
		tempPort = new Port(e.getX(), e.getY());
		tempLine = new CompositionLine(fromPort, tempPort);
		canva.addShape(tempLine);
		canva.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		tempPort.setPoint(e.getPoint());
		canva.repaint();
	}
	
	public void mouseReleased(MouseEvent e) {
		
		canva.getShapeList().remove(tempLine);
		shapeList = canva.getShapeByPoint(e.getPoint());
		if(shapeList.size() != 0) {
			if(shapeList.get(0) != canva.getSelected()) {
				toPort = shapeList.get(0).getClosetPort(e.getPoint().x, e.getPoint().y);
				canva.addShape(new CompositionLine(fromPort, toPort));
			}
		}
		canva.repaint();
	}
}
