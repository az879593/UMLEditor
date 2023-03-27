package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	private Canva canva = Canva.getInstance();
		
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenuItem group = new JMenuItem("Group");
	private JMenuItem unGroup = new JMenuItem("UnGroup");
	private JMenuItem changeObjectName = new JMenuItem("Change Object Name");
	
	public MenuBar() {
		group.addActionListener(new groupListener());
		unGroup.addActionListener(new unGroupListener());
		changeObjectName.addActionListener(new changeNameListener());
		
		editMenu.add(group);
		editMenu.add(unGroup);
		editMenu.add(changeObjectName);
		
		add(fileMenu);
		add(editMenu);
	}
	
	private class changeNameListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			canva.changeObjectName();
		}
	}
	
	private class groupListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			canva.groupShape();
		}
	}
	
	private class unGroupListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			canva.unGroupShape();
		}
		
	}
}
