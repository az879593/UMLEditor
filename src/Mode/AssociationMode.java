package Mode;

import java.awt.event.MouseEvent;

import Shape.*;

public class AssociationMode extends LineMode {
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		shapeList = canva.getShapeByPoint(e.getPoint());
		if(shapeList.size() != 0) {
			if (shapeList.get(0) != canva.getSelected()/* && !shapeList.get(0).isGroup() */) {
				toPort = shapeList.get(0).getClosetPort(e.getPoint().x, e.getPoint().y);
				canva.addShape(new AssociationLine(fromPort, toPort));
			}
		}
		canva.repaint();
	}
}
