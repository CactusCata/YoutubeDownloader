package fr.cactuscata.ytd.containers;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CJTextField extends JTextField implements DocumentListener {

	private static final long serialVersionUID = 1L;
	private boolean textChanged = true;
	private final String alertText;

	public CJTextField(int colunms, String alertText) {
		super(colunms);
		this.alertText = alertText;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		if(!this.textChanged) {
			super.setForeground(Color.BLACK);
			this.textChanged = true;
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(!this.textChanged) {
			super.setForeground(Color.BLACK);
			this.textChanged = true;
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(!this.textChanged) {
			super.setForeground(Color.BLACK);
			this.textChanged = true;
		}
	}

	public void invalidText() {
		super.setForeground(Color.RED);
		JOptionPane.showMessageDialog(null, this.alertText, "Error", JOptionPane.ERROR_MESSAGE);
		this.textChanged = false;
	}
	
}
