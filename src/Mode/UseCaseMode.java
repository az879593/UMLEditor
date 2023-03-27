package Mode;
import java.awt.event.MouseEvent;

import Shape.UseCase;

public class UseCaseMode extends Mode {
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		canva.addShape(new Class(e.getPoint().x, e.getPoint().y, 200, 200));
		canva.addShape(new UseCase(e.getPoint().x, e.getPoint().y));
		canva.repaint();
	}
}
