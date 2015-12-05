package code.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.model.KeyBricksModel;
import code.model.Observer;

public class KeyBricksGUI implements Runnable, Observer {

	private KeyBricksModel _model;
	private JPanel _board;
	
	public KeyBricksGUI(KeyBricksModel m) {
		_model = m;
		_model.setObserver(this);
	}
	
	@Override public void run() {
		JFrame window = new JFrame("KeyBricks - Lab 7");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_board = new JPanel();
		_board.setLayout(new GridLayout(_model.getRows(), _model.getCols()));
		KeyPressHandler keyHandler = new KeyPressHandler(_model);
		populateBoard();
		window.addKeyListener(keyHandler);
		window.setFocusable(true);
		window.add(_board);
		window.pack();
		window.setVisible(true);
	}

	private void populateBoard() {
		for (int c=0; c<_model.getCols(); c++) {
			for (int r=0; r<_model.getRows(); r++) {
				JButton b = new JButton();
				b.setOpaque(true);
				b.setFocusable(false);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*4));
				_board.add(b);
			}
		}
		update();
	}
	
	@Override public void update() {
		for (int c=0; c<_model.getCols(); c++) {
			for (int r=0; r<_model.getRows(); r++) {
				JButton b = (JButton) _board.getComponent(r*_model.getCols()+c);
				Character ch = _model.get(c,r).getCharacter();
				if (ch != null) {
					b.setText(ch.toString());
					b.setBackground(_model.get(c,r).getColor());
				}
				else {
					b.setText(null);
					b.setBackground(Color.BLACK);
					b.setForeground(Color.BLACK);
				}
			}
		}
	}

}
