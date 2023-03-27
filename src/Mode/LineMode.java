package Mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Shape.Port;
import Shape.Shape;

public class LineMode extends Mode {
	
	protected Shape fromShape, toShape;
	protected Port fromPort, toPort;
	protected ArrayList <Shape> shapeList;
	
	public void mousePressed(MouseEvent e) {

		shapeList = canva.getShapeByPoint(e.getPoint());
		if (shapeList.size() != 0 /* && !shapeList.get(0).isGroup() */) {
			canva.setSelected(shapeList.get(0));
			fromPort = canva.getSelected().getClosetPort(e.getPoint().x, e.getPoint().y);
		} else {
			canva.setSelected(null);
		}
		
		canva.repaint();
	}
}
