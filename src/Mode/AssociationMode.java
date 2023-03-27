package Mode;

import java.awt.event.MouseEvent;

import Shape.*;

public class AssociationMode extends LineMode {
	
	public void mousePressed(MouseEvent e) {
		getFromPort(e.getPoint());
		if(canva.getSelected() != null) {
			tempPort = new Port(e.getX(), e.getY());
			tempLine = new AssociationLine(fromPort, tempPort);
			canva.addShape(tempLine);
			canva.repaint();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(canva.getSelected() != null) {
			tempPort.setPoint(e.getPoint());
			canva.repaint();
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(canva.getSelected() != null) {
			canva.getShapeList().remove(tempLine);
			shapeList = canva.getShapeByPoint(e.getPoint());
			if(shapeList.size() != 0 && !shapeList.get(0).isGroup()) {
				if (shapeList.get(0) != canva.getSelected()/* && !shapeList.get(0).isGroup() */) {
					toPort = shapeList.get(0).getClosetPort(e.getPoint().x, e.getPoint().y);
					canva.addShape(new AssociationLine(fromPort, toPort));
				}
			}
			canva.repaint();
		}
	}
}
