package View;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import Mode.ClassMode;
import Mode.Mode;
import Mode.UseCaseMode;

public class UML extends JFrame{
	
	private Canva canva;
	private MenuBar menuBar;
	
	public UML() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("UML Editor");
		setSize(1200,900);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		canva = Canva.getInstance();
		getContentPane().add(canva, BorderLayout.CENTER);
		
		menuBar = new MenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
//		Mode useCaseMode = new UseCaseMode();	//«Ý­×§ï button -> change mode
//		Mode classMode = new ClassMode();
//		canva.addMouseListener(classMode);
//		canva.addMouseMotionListener(useCaseMode);
//		JButton bt2 = new JButton();
//		getContentPane().add(bt2, BorderLayout.WEST);
		JToolBar toolBar = new ToolBar();
		getContentPane().add(toolBar, BorderLayout.WEST);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UML mainFrame = new UML();
		
		mainFrame.setVisible(true);
		
	}

}
