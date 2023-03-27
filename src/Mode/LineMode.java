package Mode;

import java.awt.Point;
import java.util.ArrayList;

import Shape.BasicLine;
import Shape.Port;
import Shape.Shape;

public class LineMode extends Mode {
	
	protected Shape fromShape, toShape;
	protected Port fromPort, toPort;
	protected Port tempPort;
	protected BasicLine tempLine;
	protected ArrayList <Shape> shapeList;
	
	public void getFromPort(Point p) {
		shapeList = canva.getShapeByPoint(p);
		if (shapeList.size() != 0 /* && !shapeList.get(0).isGroup() */) {
			canva.setSelected(shapeList.get(0));
			fromPort = canva.getSelected().getClosetPort(p.x, p.y);
		} else {
			canva.setSelected(null);
		}
	}
}
