package Mode;

import java.awt.event.MouseEvent;

import Shape.Class;

public class ClassMode extends Mode {
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		canva.addShape(new Class(e.getPoint().x, e.getPoint().y));
//		canva.addShape(new UseCase(e.getPoint().x, e.getPoint().y, 200, 200));
		canva.repaint();
	}
}
