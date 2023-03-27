package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Mode.*;


public class ToolBar extends JToolBar {
	
	private JButton selectButton = new ModeButton();
	private JButton associationButton = new ModeButton();
	private JButton generalizationButton = new ModeButton();
	private JButton compositionButton = new ModeButton();
	private JButton classButton;
	private JButton useCaseButton;
	
	public ToolBar() {
		
		ImageIcon selectButtonIcon = new ImageIcon("img/select.png");
		selectButton = new ModeButton(new SelectMode(), selectButtonIcon);
		add(selectButton);
		
		ImageIcon associationButtonIcon = new ImageIcon("img/association.png");
		associationButton = new ModeButton(new AssociationMode(), associationButtonIcon);
		add(associationButton);
		
		ImageIcon generalizationButtonIcon = new ImageIcon("img/generalization.png");
		generalizationButton = new ModeButton(new GeneralizationMode(), generalizationButtonIcon);
		add(generalizationButton);
		
		ImageIcon compositionButtonIcon = new ImageIcon("img/composition.png");
		compositionButton = new ModeButton(new CompositionMode(), compositionButtonIcon);
		add(compositionButton);
		
		ImageIcon classButtonIcon = new ImageIcon("img/class.png");
		classButton = new ModeButton(new ClassMode(), classButtonIcon);
		add(classButton);
		
		ImageIcon useCaseButtonIcon = new ImageIcon("img/usecase.png");
		useCaseButton = new ModeButton(new UseCaseMode(), useCaseButtonIcon);
		add(useCaseButton);
		
		
		
		setFloatable(false);
		setLayout(new GridLayout(0, 1));
	}
	
	public void resetButtonBackground() {
		Component [] allButton = this.getComponents();
		for(Component c : allButton) {
			c.setBackground(Color.white);
		}
	}
	
	private class ModeButton extends JButton {
		
		private Canva canva = Canva.getInstance();
		private Mode mode;
		
		private Dimension buttonSize = new Dimension(150,150);
		
		public ModeButton() {
			setPreferredSize(new Dimension(150,150));
			setBackground(Color.white);
		}
		
		public ModeButton(Mode mode, ImageIcon icon) {
			
			setPreferredSize(buttonSize);
			setBackground(Color.white);
			this.mode = mode;	
			setIcon(icon);
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					canva.setMode(mode);
					resetButtonBackground();
					setBackground(Color.gray);
				}
			});
		}
	}

}
